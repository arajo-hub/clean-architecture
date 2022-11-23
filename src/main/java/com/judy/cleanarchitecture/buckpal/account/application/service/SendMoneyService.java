package com.judy.cleanarchitecture.buckpal.account.application.service;

import com.judy.cleanarchitecture.buckpal.account.application.port.in.SendMoneyCommand;
import com.judy.cleanarchitecture.buckpal.account.application.port.in.SendMoneyUseCase;
import com.judy.cleanarchitecture.buckpal.account.application.port.out.LoadAccountPort;
import com.judy.cleanarchitecture.buckpal.account.application.port.out.UpdateAccountStatePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SendMoneyService implements SendMoneyUseCase {

    private final LoadAccountPort loadAccountPort; // 계좌를 불러오기 위해 호출.
    private final AccountLock accountLock;
    private final UpdateAccountStatePort updateAccountStatePort; // 계좌 상태를 업데이트하기 위해 호출.

    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        // TODO: 비즈니스 규칙 검증
        // TODO: 모델 상태 조작
        // TODO: 출력 값 반환
    }

}
