package com.github.maratmingazov.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfiguration {

    /**
     * Spring Boot processes command-line arguments and injects the token here.
     * Alternatively, it can be provided via application.yml:
     * token: your_token_here
     * */
    @Value("${MIRO_TOKEN}")
    private String miroToken;

    @Bean
    public RestClient miroClient() {
        return RestClient.builder()
                .baseUrl("https://api.miro.com/v2/")
                .defaultHeader("Accept", "application/json")
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("Authorization", "Bearer " + miroToken)
                .build();
    }
}
