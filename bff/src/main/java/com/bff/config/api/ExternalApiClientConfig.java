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
    public com.bff.enciclopedia.invoker.ApiClient msEnciclopediaApiClient() {
        com.bff.enciclopedia.invoker.ApiClient apiClient = new com.bff.enciclopedia.invoker.ApiClient(restTemplate);
        apiClient.setBasePath("http://localhost:8085");
        return apiClient;
    }
    @Primary
    @Bean
    public com.bff.info.invoker.ApiClient msInfoApiClient() {
        com.bff.info.invoker.ApiClient apiClient = new com.bff.info.invoker.ApiClient(restTemplate);
        apiClient.setBasePath("http://localhost:8086");
        return apiClient;
    }
    @Primary
    @Bean
    public com.bff.msmedico.invoker.ApiClient msMedicoApiClient() {
        com.bff.msmedico.invoker.ApiClient apiClient = new com.bff.msmedico.invoker.ApiClient(restTemplate);
        apiClient.setBasePath("http://localhost:8081");
        return apiClient;
    }

}
