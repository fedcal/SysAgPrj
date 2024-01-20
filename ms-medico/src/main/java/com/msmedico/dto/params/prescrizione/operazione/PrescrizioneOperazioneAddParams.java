package com.msmedico.dto.params.prescrizione.operazione;

import lombok.Data;

@Data
public class PrescrizioneOperazioneAddParams {
    private Integer operazioneMedica;
    private Integer cartellaClinica;
    private Integer medico;
}
