package com.greedie.pay.moneyservice.adapter.in;

public record ChargeMoneyRequest (
        String membershipId,
        String amount,
        String currency
) {
}
