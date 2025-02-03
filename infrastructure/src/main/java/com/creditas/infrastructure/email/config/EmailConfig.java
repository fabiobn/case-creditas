package com.creditas.infrastructure.email.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-infra.properties")
@ConfigurationProperties(prefix = "email")
public class EmailConfig {
    @Value("${email.smtp.auth}")
    private Boolean auth;
    @Value("${email.smtp.starttls.enable}")
    private Boolean enable;
    @Value("${email.smtp.host}")
    private String host;
    @Value("${email.smtp.port}")
    private String port;
    @Value("${email.smtp.ssl.trust}")
    private String trust;
}
