package com.msinfo.config.api;

import com.msinfo.esito.Esito;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.GenericResponseConverter;
import com.msinfo.esito.GenericResponseDto;
import com.msinfo.exception.EsitoRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class EsitoResponseErrorHandler extends DefaultResponseErrorHandler {
    /**
     * The Generic response converter.
     */
    private final GenericResponseConverter genericResponseConverter;

    /**
     * The Esito messaggi request context holder.
     */
    private final EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    /**
     * Handle error.
     *
     * @param response the response
     * @throws IOException the io exception
     */
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

        GenericResponseDto<Void> responseDto = genericResponseConverter.convertGenericResponse(response.getBody());
        Esito esito = responseDto.getEsito();
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(esito.getMessaggi());
        throw new EsitoRuntimeException((HttpStatus) response.getStatusCode());
    }
}
