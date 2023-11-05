package com.robotmedico.esito;

import com.robotmedico.esito.costants.EsitoOperazioneEnum;
import com.robotmedico.esito.costants.SeveritaMessaggioEnum;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class EsitoMessaggiRequestContextHolder {
    private final List<Messaggio> messaggi = new ArrayList<>();

    public <T> GenericResponseDto<T> buildGenericResponse(T payload) {

        Esito esito = new Esito();
        esito.setCodRet(messaggi.stream().anyMatch(m -> SeveritaMessaggioEnum.WARNING.equals(m.getSeverita())) ? EsitoOperazioneEnum.WARNING : EsitoOperazioneEnum.OK);
        esito.setMessaggi(messaggi);

        GenericResponseDto<T> responseDto = new GenericResponseDto<>();
        responseDto.setEsito(esito);
        responseDto.setPayload(payload);

        return responseDto;
    }
}
