package com.msmedico.config.api;

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
    public com.msmedico.msinfermiere.invoker.ApiClient msInfermiereApiClient() {
        com.msmedico.msinfermiere.invoker.ApiClient apiClient = new com.msmedico.msinfermiere.invoker.ApiClient(restTemplate);
        apiClient.setBasePath("http://localhost:8082");
        return apiClient;
    }
}
