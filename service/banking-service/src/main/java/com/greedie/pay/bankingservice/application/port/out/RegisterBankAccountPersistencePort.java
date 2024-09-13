package com.greedie.pay.bankingservice.application.port.out;

public interface RegisterBankAccountPersistencePort {
    void registerBankAccount(String membershipId, String bankName, String bankAccountNumber, Boolean isValid);
}
