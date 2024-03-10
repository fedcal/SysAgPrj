package com.mspaziente.dto.params.creazionecartellaclinica;

import lombok.Data;

@Data
public class AggiungiRefertoOperazioneParams {
    private String tipologia;
    private String descrizione;
    private String dataReferto;
}
