package com.sk.introductionTospringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {

    @Value("${deploy.env:prod}")
    private String env;

    @Bean
    public DB db() {
        return switch (env.toLowerCase()) {
            case "dev" -> new DevDB();
            case "prod" -> new ProdDB();
            default -> throw new IllegalArgumentException("Invalid value for 'deploy.env': " + env);
        };
    }
}
