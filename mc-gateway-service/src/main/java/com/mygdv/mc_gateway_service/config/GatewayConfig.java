package com.mygdv.mc_gateway_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
public class GatewayConfig {

    @Value("${microservices.customer-service-url}")
    private String customerServiceUrl;

    @Value("${microservices.account-service-url}")
    private String accountServiceUrl;

    @Value("${microservices.credit-disbursement-service-url}")
    private String creditDisbursementServiceUrl;

    @Value("${gateway.retry.attempts}")
    private int retryAttempts;

    private Set<String> getAllSxxStatusCodes() {
        return IntStream.rangeClosed(500, 599)
                .mapToObj(String::valueOf)
                .collect(Collectors.toSet());
    }

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        Set<String> statusCodeSxx = getAllSxxStatusCodes();
        return routeLocatorBuilder.routes()
                .route("customer-service", r -> r.path("/customers/**")
                                .filters(f -> f
                                        .circuitBreaker(cd -> cd.setName("customerServiceCircuitBreaker")
                                                .setFallbackUri("forward:/fallback/customers"))
                                        .retry(retryConfig -> retryConfig.setRetries(retryAttempts)
                                                .setStatuses(HttpStatus.INTERNAL_SERVER_ERROR))
                                )
                                .uri(customerServiceUrl))
                .route("account-service", r -> r.path("/accounts/**")
                        .filters(f -> f
                                .circuitBreaker(cb -> cb.setName("accountServiceCircuitBreaker")
                                        .setFallbackUri("forward:/fallback/accounts"))
                                .retry(retry -> retry.setRetries(retryAttempts)
                                        .setStatuses(HttpStatus.INTERNAL_SERVER_ERROR))
                        )
                        .uri(accountServiceUrl))
                .route("credit-disbursement-service", r -> r.path("/credit-disbursements/**")
                        .filters(f -> f
                                .circuitBreaker(cb -> cb.setName("creditDisbursementCircuitBreaker")
                                        .setFallbackUri("forward:/fallback/credit-disbursements"))
                                .retry(retry -> retry.setRetries(retryAttempts)
                                        .setStatuses(HttpStatus.INTERNAL_SERVER_ERROR))
                        )
                        .uri(creditDisbursementServiceUrl))
                .build();
    }

}