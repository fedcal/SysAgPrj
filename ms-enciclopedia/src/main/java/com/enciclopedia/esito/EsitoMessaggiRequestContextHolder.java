package com.enciclopedia.esito;

import com.enciclopedia.esito.costants.EsitoOperazioneEnum;
import com.enciclopedia.esito.costants.SeveritaMessaggioEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class EsitoMessaggiRequestContextHolder {
    /**
     * The Messaggi.
     */
    private final List<Messaggio> messaggi = new ArrayList<>();

    private  EsitoOperazioneEnum codRet;    //l’esito dell’operazione; EsitoOperazioneEnum
    private  String operationId;


    /**
     * Build generic response generic response dto.
     *
     * @param <T>         the type parameter
     * @param payload     the payload
     * @return the generic response dto
     */
    public <T> GenericResponseDto<T> buildGenericResponse(T payload) {

        Esito esito = new Esito();
        esito.setCodRet(messaggi.stream().anyMatch(m -> SeveritaMessaggioEnum.WARNING.equals(m.getSeverita())) ? EsitoOperazioneEnum.WARNING : EsitoOperazioneEnum.OK);
        esito.setMessaggi(messaggi);
        esito.setCodRet(codRet);
        esito.setOperationId(operationId);

        GenericResponseDto<T> responseDto = new GenericResponseDto<>();
        responseDto.setEsito(esito);
        responseDto.setPayload(payload);

        return responseDto;
    }
}
