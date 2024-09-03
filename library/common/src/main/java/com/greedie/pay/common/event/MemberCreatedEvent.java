package com.greedie.pay.common.event;

public record MemberCreatedEvent(
        String membershipId,
        String username,
        Boolean isCorp,
        String email,
        String address
) {
}
