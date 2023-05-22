package ru.anvarzhonov.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AuthAppConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    ObjectMapper objectMapper() {
        var mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        return mapper;
    }
}
