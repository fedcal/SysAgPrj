package com.msmedico.dto.params.prescrizione.medicinale;

import lombok.Data;

@Data
public class PrescrizioneMedicinaleInfoParams {
    private Integer idRelazione;
    private Integer idMedico;
    private Integer idMedicinale;
    private Integer idCartellaClinica;
    private Integer idPaziente;

    private String nomeMedico;
    private String cognomeMedico;
    private String nomePaziente;
    private String cognomePaziente;
    private String nomeMedicinale;
}
