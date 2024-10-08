package com.greedie.pay.membership.application.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greedie.pay.common.event.MemberCreatedEvent;
import com.greedie.pay.membership.application.port.in.SignUpRequestCommand;
import com.greedie.pay.membership.application.port.in.SignUpRequestUseCase;
import com.greedie.pay.membership.application.port.out.SignUpPersistencePort;
import com.greedie.pay.membership.domain.Membership;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MemberSignUpService implements SignUpRequestUseCase {
    private final SignUpPersistencePort signUpPersistencePort;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Membership signUp(SignUpRequestCommand command) {
        Membership membership = new Membership(
                UUID.randomUUID().toString(),
                command.getUsername(),
                command.getPassword(),
                command.getEmail(),
                command.getAddress(),
                true,
                command.isCorp()
        );

        signUpPersistencePort.registerMember(membership);

        kafkaTemplate.send("member-signup-initialize", new MemberCreatedEvent(membership.getMembershipId(), membership.getName(), membership.isCorp(), membership.getEmail(), membership.getAddress()))
                .whenComplete((action, throwable) -> {
                    if(throwable == null) {
                        log.info("membership signup action completed: {}", action);
                    } else {
                        log.error("membership signup action failed: {}", throwable, throwable);
                    }
                });

        return membership;
    }

    @KafkaListener(id = "moneyCreateFail", topics = "money-create-fail")
    public void moneyInitialize(String membershipId) {
        signUpPersistencePort.invalidateMembership(membershipId);
    }
}
