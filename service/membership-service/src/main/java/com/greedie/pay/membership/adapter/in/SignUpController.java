package com.greedie.pay.membership.adapter.in;

import com.greedie.pay.common.WebAdapter;
import com.greedie.pay.membership.application.port.in.SignUpRequestCommand;
import com.greedie.pay.membership.application.port.in.SignUpRequestUseCase;
import com.greedie.pay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class SignUpController {
    private final SignUpRequestUseCase signUpRequestUseCase;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest body) {
        SignUpRequestCommand signUpRequestCommand = new SignUpRequestCommand(
                body.username(),
                body.password(),
                body.email(),
                body.address(),
                body.isCorp()
        );

        Membership membership = signUpRequestUseCase.signUp(signUpRequestCommand);

        return ResponseEntity.ok(membership);
    }
}
