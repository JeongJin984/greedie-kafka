package com.greedie.pay.bankingservice.application.port.in;

public record RegisterBankAccountCommand (
        String membershipId,
        String bankName,
        String bankAccountNumber
) {
}
