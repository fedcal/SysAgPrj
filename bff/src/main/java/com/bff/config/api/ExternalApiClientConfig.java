package com.bff.config.api;


import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class ExternalApiClientConfig {

    /**
     * The Rest template.
     */
    private final RestTemplate restTemplate;
    @Primary
    @Bean
    public com.bff.enciclopedia.invoker.ApiClient msCiclomotoriApiClient() {
        com.bff.enciclopedia.invoker.ApiClient apiClient = new com.bff.enciclopedia.invoker.ApiClient(restTemplate);
        apiClient.setBasePath("http://localhost:8085");
        return apiClient;
    }

}
