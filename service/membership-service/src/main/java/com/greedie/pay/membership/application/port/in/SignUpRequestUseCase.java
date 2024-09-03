package com.greedie.pay.membership.application.port.in;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.greedie.pay.membership.domain.Membership;

public interface SignUpRequestUseCase {
    Membership signUp(SignUpRequestCommand command);
}
