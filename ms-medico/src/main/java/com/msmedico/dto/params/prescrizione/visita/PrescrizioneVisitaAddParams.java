package com.msmedico.dto.params.prescrizione.visita;

import lombok.Data;

@Data
public class PrescrizioneVisitaAddParams {
    private Integer visitaMedica;
    private Integer cartellaClinica;
    private Integer medico;
}
