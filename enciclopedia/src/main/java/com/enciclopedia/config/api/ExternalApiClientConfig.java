package com.enciclopedia.config.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ExternalApiClientConfig {
    /**
     * The Rest template.
     */
    private final RestTemplate restTemplate;
    /*@Primary
    @Bean
    public it.dtt.bff.ciclomotori.msciclomotori.invoker.ApiClient msCiclomotoriApiClient() {
        it.dtt.bff.ciclomotori.msciclomotori.invoker.ApiClient apiClient = new it.dtt.bff.ciclomotori.msciclomotori.invoker.ApiClient(restTemplate);
        apiClient.setBasePath("http://localhost:8082");
        return apiClient;
    }*/
}
