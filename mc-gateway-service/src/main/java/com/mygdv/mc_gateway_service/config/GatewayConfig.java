package com.mygdv.mc_gateway_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Value("${microservices.customer-service-url}")
    private String customerServiceUrl;

    @Value("${microservices.account-service-url}")
    private String accountServiceUrl;

    @Value("${microservices.credit-disbursement-service-url}")
    private String creditDisbursementServiceUrl;

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("customer-service",
                        r -> r.path("/customers/**").uri(customerServiceUrl))
                .route("account-service",
                        r -> r.path("/accounts/**").uri(accountServiceUrl))
                .route("credit-disbursement-service",
                        r -> r.path("/credit-disbursements/**").uri(creditDisbursementServiceUrl))
                .build();
    }

}