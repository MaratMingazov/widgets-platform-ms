package com.github.maratmingazov.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Log4j2
@Configuration
public class AppConfiguration {

    /**
     * Spring Boot processes command-line arguments and injects the token here.
     * Alternatively, it can be provided via application.yml:
     * token: your_token_here
     * */
    //@Value("${MIRO_TOKEN}") // when we run app from IDEA (provide token as program property)
    @Value("${MIRO_TOKEN}") // when we run app as jar (provide token as ENV variable)
    private String miroToken;

    @Bean
    public RestClient miroClient() {
        log.info("MIRO TOKEN: " + miroToken);
        return RestClient.builder()
                .baseUrl("https://api.miro.com/v2/")
                .defaultHeader("Accept", "application/json")
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("Authorization", "Bearer " + miroToken)
                .build();
    }
}
