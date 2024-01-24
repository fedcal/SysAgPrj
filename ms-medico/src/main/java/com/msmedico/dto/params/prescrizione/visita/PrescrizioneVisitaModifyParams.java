package com.msmedico.dto.params.prescrizione.visita;

import lombok.Data;

@Data
public class PrescrizioneVisitaModifyParams {
    private Integer idRelazione;

    private Integer nuovaVisitaMedica;
    private Integer nuovaCartellaClinica;
    private Integer nuovoMedico;
}
