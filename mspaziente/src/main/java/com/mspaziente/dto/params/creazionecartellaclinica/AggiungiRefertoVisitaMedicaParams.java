package com.mspaziente.dto.params.creazionecartellaclinica;

import lombok.Data;

@Data
public class AggiungiRefertoVisitaMedicaParams {
    private String descrizione;
    private String tipologia;
    private String dataReferto;
}
