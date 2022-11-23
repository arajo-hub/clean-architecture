package com.judy.cleanarchitecture.buckpal.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Account {

    private AccountId id;
    private Money baselineBalance; // 첫번째 활동 바로 전의 잔고. 현재 총 잔고는 baselineBalance에 활동창의 모든 활동들의 잔고를 합한 값.
    private ActivityWindow activityWindow;

    public Money calculateBalance() {
        return Money.add(
                this.baselineBalance,
                this.activityWindow.calculateBalance(this.id)
        );
    }

    public boolean withdraw(Money money, AccountId targetAccountId) {
        if (!mayWithdraw(money)) {
            return false;
        }

        Activity withdrawal = new Activity(
                this.id,
                this.id,
                targetAccountId,
                LocalDateTime.now(),
                money
        );

        this.activityWindow.addActivity(withdrawal);
        return true;

    }

    private boolean mayWithdraw(Money money) {
        return Money.add(
                this.calculateBalance(),
                money.negate()
        ).isPositive();
    }

    public boolean deposit(Money money, AccountId sourceAccountId) {
        Activity deposit = new Activity(
                this.id,
                sourceAccountId,
                this.id,
                LocalDateTime.now(),
                money
        );
        this.activityWindow.addActivity(deposit);
        return true;
    }

}
