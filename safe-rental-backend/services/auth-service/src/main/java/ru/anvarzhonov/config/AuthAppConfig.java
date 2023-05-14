package ru.anvarzhonov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AuthAppConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
