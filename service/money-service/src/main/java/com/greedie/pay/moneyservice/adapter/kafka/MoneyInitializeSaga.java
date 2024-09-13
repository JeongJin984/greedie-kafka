package com.greedie.pay.moneyservice.adapter.kafka;

import com.greedie.pay.common.event.MemberCreatedEvent;
import com.greedie.pay.moneyservice.application.port.in.CreateMemberMoneyCommand;
import com.greedie.pay.moneyservice.application.port.in.MemberMoneyUseCase;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class MoneyInitializeSaga {
    private final MemberMoneyUseCase memberMoneyUseCase;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(id = "moneyInitialization", topics = "member-signup-initialize")
    public void moneyInitialize(MemberCreatedEvent event) {
        try {
            memberMoneyUseCase.createMemberMoney(new CreateMemberMoneyCommand(
                    event.membershipId(),
                    null,
                    BigDecimal.ZERO
            ));
        } catch (Exception e) {
            log.error("Error occurred when initializing memberMoney {} event: {}", e, event);
            kafkaTemplate.send("money-create-fail", event.membershipId());
        }

    }
}
