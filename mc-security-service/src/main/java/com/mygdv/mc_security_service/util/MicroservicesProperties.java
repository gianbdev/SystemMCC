package com.mygdv.mc_security_service.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
//@Configuration
@Component
@ConfigurationProperties(prefix = "mc-security")
public class MicroservicesProperties {

    List<Application> applications;

    @Data
    public static class Application {

        private String clientId;

        private String clientSecret;

    }

}