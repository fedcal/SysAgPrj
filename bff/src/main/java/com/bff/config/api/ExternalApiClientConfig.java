package com.bff.config.api;

import com.bff.esito.Esito;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.bff.exception.EsitoRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

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
