package com.bff.dto.msmedico.params.prescrizione.operazione;

import lombok.Data;

@Data
public class PrescrizioneOperazioneAddParams {
    private Integer operazioneMedica;
    private Integer cartellaClinica;
    private Integer medico;
}
