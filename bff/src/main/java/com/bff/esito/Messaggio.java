package com.bff.esito;

import com.bff.esito.costants.SeveritaMessaggioEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Messaggio {
    /**
     * The Severita.
     */
    private SeveritaMessaggioEnum severita; //livello di criticita’ del messaggio da visualizzare (colorazione del Toaster FE); SeveritaMessaggioEnum
    /**
     * The Cod msg.
     */
    private String codMsg;    //codice del messaggio che deve essere visualizzato, poi decodificato dal FE
    /**
     * The Parametri.
     */
    private List<Parametro> parametri;    //i valori da sostituire nella stringa del messaggio utente
}
