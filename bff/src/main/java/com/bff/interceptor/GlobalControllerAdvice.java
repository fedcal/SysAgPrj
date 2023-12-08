package com.bff.interceptor;

import com.bff.esito.Esito;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseDto;
import com.bff.esito.costants.EsitoOperazioneEnum;
import com.bff.exception.EsitoRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerAdvice {
    /**
     * The Esito messaggi request context holder.
     */
    private final EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    /**
     * Manage esito runtime exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(EsitoRuntimeException.class)
    public ResponseEntity<GenericResponseDto<Void>> manageEsitoRuntimeException(EsitoRuntimeException e) {

        Esito esito = new Esito();
        esito.setCodRet(EsitoOperazioneEnum.KO);
        esito.setMessaggi(esitoMessaggiRequestContextHolder.getMessaggi());

        GenericResponseDto<Void> responseDto = new GenericResponseDto<>();
        responseDto.setEsito(esito);

        return new ResponseEntity<>(responseDto, e.getReturnStatus());
    }
}
