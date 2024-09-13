package com.greedie.pay.bankingservice.adapter.in.request;

public record FirmbankingWebRequest(
        String fromBankName,
        String fromBankAccountNumber,
        String toBankName,
        String toBankAccountNumber,
        int moneyAmount
) {
}
