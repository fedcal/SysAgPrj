package com.bff.dto.msmedico.params.prescrizione.medicinale;

import lombok.Data;

@Data
public class PrescrizioneMedicinaleAddParams {
    private Integer idMedico;
    private Integer idMedicinale;
    private Integer idCartellaClinica;
}
