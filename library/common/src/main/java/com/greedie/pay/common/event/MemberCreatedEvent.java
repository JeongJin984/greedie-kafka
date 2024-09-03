package com.greedie.pay.common.event;

public record MemberCreatedEvent(
        String membershipId,
        String initAmount,
        String currency
) {
}
