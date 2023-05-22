package ru.anvarzhonov.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {
    private final JwtAuthenticationFilter filter;
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()

                .route("auth-service", r -> r.path("/auth/**")
                        .uri("lb://auth-service"))

                .route("user-service", r -> r.path("/users/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://user-service"))

                .route("safe-map-service", r -> r.path("/map/**")
                        .uri("lb://safe-map-service"))

                .route("calculations-service", r -> r.path("/calc/**")
                        .uri("lb://calculations-service"))

                .build();
    }

}
