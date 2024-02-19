package com.msinfermiere.dto.params.medicinaleoperazioni;

import lombok.Data;

@Data
public class FiltraMedicinalePrescrizioniParams {
    private Integer idPrescrizioneMedicinale;
    private Integer idMedico;
    private Integer idMedicinale;
    private Integer idCartellaClinica;

    private String nomeMedico;
    private String cognomeMedico;
    private String nomeMedicinale;
    private String nomePaziente;
    private String cognomePaziente;

}
