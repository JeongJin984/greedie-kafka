package com.greedie.pay.membership.adapter.in;

public record SignUpRequest (
        String username,
        String password,
        String email,
        String address,
        boolean isCorp
) {
}
