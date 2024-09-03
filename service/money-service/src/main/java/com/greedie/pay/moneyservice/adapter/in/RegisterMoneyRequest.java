package com.greedie.pay.moneyservice.adapter.in;

public record RegisterMoneyRequest (
        String ownerMembershipId,
        String currency,
        String money
) {
}
