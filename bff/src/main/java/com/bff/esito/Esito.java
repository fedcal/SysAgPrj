package com.bff.esito;

import com.bff.esito.costants.EsitoOperazioneEnum;
import lombok.Data;

import java.util.List;
@Data
public class Esito {
    /**
     * The Cod ret.
     */
    private EsitoOperazioneEnum codRet;    //l’esito dell’operazione; EsitoOperazioneEnum
    /**
     * The Messaggi.
     */
    private List<Messaggio> messaggi;    //l’array dove si trovano tutti i messaggi da visualizzare all’utente
    private String operationId;    //codice univoco che identifica l’operazione
}
