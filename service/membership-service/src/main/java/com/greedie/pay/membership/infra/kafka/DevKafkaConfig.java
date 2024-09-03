package com.greedie.pay.membership.infra.kafka;

import org.apache.kafka.clients.NetworkClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@Profile("dev")
@Configuration
@EnableKafka
public class DevKafkaConfig {

    @Bean
    public NewTopic testTopic() {
        return TopicBuilder.name("test-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic memberMoneyRegisterTopic() {
        return TopicBuilder.name("member-signup-initialize")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
