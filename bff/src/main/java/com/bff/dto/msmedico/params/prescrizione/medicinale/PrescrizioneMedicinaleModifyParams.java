package com.bff.dto.msmedico.params.prescrizione.medicinale;

import lombok.Data;

@Data
public class PrescrizioneMedicinaleModifyParams {
    private Integer idRelazione;

    private Integer nuovoMedicinale;
    private Integer nuovaCartellaClinica;
    private Integer nuovoMedico;
}
