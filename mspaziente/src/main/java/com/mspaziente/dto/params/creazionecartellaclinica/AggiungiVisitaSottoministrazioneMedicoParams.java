package com.mspaziente.dto.params.creazionecartellaclinica;

import lombok.Data;

@Data
public class AggiungiVisitaSottoministrazioneMedicoParams {
    private Integer idMedico;
    private Integer idCartellaClinica;
    private Integer idVisita;
}
