package com.greedie.pay.moneyservice.application.port.out;

import com.greedie.pay.moneyservice.adapter.out.service.RegisteredBankAccount;

public interface GetRegisteredBankAccount {
    RegisteredBankAccount getRegisteredBankAccount(String membershipId);
}
