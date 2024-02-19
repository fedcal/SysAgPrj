package com.msinfermiere.dto.params.visiteoperazioni;

import lombok.Data;

@Data
public class FiltraVisitePrescrizioniParams {
    private Integer idPrescrizioneMedicinale;
    private Integer idMedico;
    private Integer idVisita;
    private Integer idCartellaClinica;

    private String nomeMedico;
    private String cognomeMedico;
    private String nomeVisita;
    private String nomePaziente;
    private String cognomePaziente;
}
