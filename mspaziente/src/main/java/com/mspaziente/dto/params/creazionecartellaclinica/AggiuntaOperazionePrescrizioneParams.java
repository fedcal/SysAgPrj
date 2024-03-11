package com.mspaziente.dto.params.creazionecartellaclinica;

import lombok.Data;

@Data
public class AggiuntaOperazionePrescrizioneParams {
    private Integer idOperazione;
    private Integer idCartella;
    private Integer idMedico;
}
