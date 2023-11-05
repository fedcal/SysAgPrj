package com.robotmedico.esito;

import com.robotmedico.esito.costants.EsitoOperazioneEnum;
import lombok.Data;

import java.util.List;

@Data
public class Esito {
    private EsitoOperazioneEnum codRet;    //l’esito dell’operazione; EsitoOperazioneEnum
    private List<Messaggio> messaggi;
}
