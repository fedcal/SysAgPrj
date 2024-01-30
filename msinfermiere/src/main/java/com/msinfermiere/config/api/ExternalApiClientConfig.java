package com.msinfermiere.config.api;

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
    public com.msinfermiere.msmedico.invoker.ApiClient msMedicoApiClient() {
        com.msinfermiere.msmedico.invoker.ApiClient apiClient = new com.msinfermiere.msmedico.invoker.ApiClient(restTemplate);
        apiClient.setBasePath("http://localhost:8081");
        return apiClient;
    }
}
