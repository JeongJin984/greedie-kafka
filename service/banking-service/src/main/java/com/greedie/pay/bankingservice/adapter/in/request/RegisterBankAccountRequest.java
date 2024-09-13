package com.greedie.pay.bankingservice.adapter.in.request;

public record RegisterBankAccountRequest (
        String membershipId,
        String bankName,
        String bankAccountNumber,
        boolean isValid
) {
}
