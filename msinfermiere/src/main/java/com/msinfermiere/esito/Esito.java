package com.msinfermiere.esito;

import com.msinfermiere.esito.constants.EsitoOperazioneEnum;
import lombok.Data;

import java.util.List;
@Data
public class Esito {
    private EsitoOperazioneEnum codRet;    //l’esito dell’operazione; EsitoOperazioneEnum
    private String operationId;    //codice univoco che identifica l’operazione
    private List<Messaggio> messaggi;
}
