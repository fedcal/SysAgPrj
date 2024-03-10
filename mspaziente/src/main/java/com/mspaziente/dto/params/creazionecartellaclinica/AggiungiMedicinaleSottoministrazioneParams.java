package com.mspaziente.dto.params.creazionecartellaclinica;

import lombok.Data;

@Data
public class AggiungiMedicinaleSottoministrazioneParams {
    private Integer idInfermiere;
    private Integer idMedicinale;
    private Integer idCartellaClinica;
}
