package com.mspaziente.config.api;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class ExternalApiClientConfig {
    /**
     * The Rest template.
     */
    private final RestTemplate restTemplate;

    @Primary
    @Bean
    public com.mspaziente.msmedico.invoker.ApiClient msMedicoApiClient() {
        com.mspaziente.msmedico.invoker.ApiClient apiClient = new com.mspaziente.msmedico.invoker.ApiClient(restTemplate);
        apiClient.setBasePath("http://localhost:8081");
        return apiClient;
    }
    @Primary
    @Bean
    public com.mspaziente.msinfermiere.invoker.ApiClient msInfermiereApiClient() {
        com.mspaziente.msinfermiere.invoker.ApiClient apiClient = new com.mspaziente.msinfermiere.invoker.ApiClient(restTemplate);
        apiClient.setBasePath("http://localhost:8082");
        return apiClient;
    }
}