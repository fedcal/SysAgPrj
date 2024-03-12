package com.mspaziente.dto.params.creazionecartellaclinica;

import lombok.Data;

@Data
public class AggiungiVisitaSottoministrazioneInfermiereParams {
    private Integer idInfermiere;
    private Integer idVisita;
    private Integer idCartellaClinica;
}
