package com.msmedico.dto.params.prescrizione.visita;

import lombok.Data;

@Data
public class PrescrizioneVisitaInfoParams {
    private Integer idRelazione;
    private Integer idMedico;
    private Integer idCartella;
    private Integer idVisita;
    private Integer idPaziente;

    private String nomeVisita;
    private String nomeMedico;
    private String cognomeMedico;
    private String nomePaziente;
    private String cognomePaziente;
}
