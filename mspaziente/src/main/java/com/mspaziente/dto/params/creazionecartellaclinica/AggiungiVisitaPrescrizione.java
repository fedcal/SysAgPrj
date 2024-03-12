package com.mspaziente.dto.params.creazionecartellaclinica;

import lombok.Data;

@Data
public class AggiungiVisitaPrescrizione {
    private Integer idMedico;
    private Integer idVisita;
    private Integer idCartellaClinica;
}
