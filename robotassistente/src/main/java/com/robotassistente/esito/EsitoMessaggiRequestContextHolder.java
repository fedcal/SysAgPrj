package com.robotassistente.esito;

import com.robotassistente.esito.costants.EsitoOperazioneEnum;
import com.robotassistente.esito.costants.SeveritaMessaggioEnum;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class EsitoMessaggiRequestContextHolder {
    private final List<Messaggio> messaggi = new ArrayList<>();

    public <T> GenericResponseDto<T> buildGenericResponse(String operationId, T payload) {

        Esito esito = new Esito();
        esito.setCodRet(messaggi.stream().anyMatch(m -> SeveritaMessaggioEnum.WARNING.equals(m.getSeverita())) ? EsitoOperazioneEnum.WARNING : EsitoOperazioneEnum.OK);
        esito.setOperationId(operationId);
        esito.setMessaggi(messaggi);

        GenericResponseDto<T> responseDto = new GenericResponseDto<>();
        responseDto.setEsito(esito);
        responseDto.setPayload(payload);

        return responseDto;
    }
}
