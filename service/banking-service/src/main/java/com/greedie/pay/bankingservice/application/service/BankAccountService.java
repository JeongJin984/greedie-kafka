package com.greedie.pay.bankingservice.application.service;

import com.greedie.pay.bankingservice.application.port.in.RegisterBankAccountCommand;
import com.greedie.pay.bankingservice.application.port.in.RegisterBankAccountUseCase;
import com.greedie.pay.bankingservice.application.port.out.RegisterBankAccountPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAccountService implements RegisterBankAccountUseCase {
    private final RegisterBankAccountPersistencePort registerBankAccountPersistencePort;

    @Override
    public void registerBankAccount(RegisterBankAccountCommand command) {
        registerBankAccountPersistencePort.registerBankAccount(
                command.membershipId(),
                command.bankName(),
                command.bankAccountNumber(),
                true
        );

        
    }
}
