package com.msmedico.dto.params.prescrizione.medicinale;

import lombok.Data;

@Data
public class PrescrizioneMedicinaleAddParams {
    private Integer idMedico;
    private Integer idMedicinale;
    private Integer idCartellaClinica;
}
