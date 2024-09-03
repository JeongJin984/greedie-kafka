package com.greedie.pay.moneyservice.common;

import com.greedie.pay.common.CommonHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    @Bean
    public CommonHttpClient commonHttpClient() {
        return new CommonHttpClient();
    }
}
