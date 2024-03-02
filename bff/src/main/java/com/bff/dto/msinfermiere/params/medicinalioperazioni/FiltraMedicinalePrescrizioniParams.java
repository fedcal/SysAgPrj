package com.bff.dto.msinfermiere.params.medicinalioperazioni;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FiltraMedicinalePrescrizioniParams {
    @Schema(description = "Id prescrizione medicinale",type = "int")
    private Integer idPrescrizioneMedicinale;
    @Schema(description = "Id medico",type = "int")
    private Integer idMedico;
    @Schema(description = "Id medicinale",type = "int")
    private Integer idMedicinale;
    @Schema(description = "Id cartella clinica",type = "int")
    private Integer idCartellaClinica;

    @Schema(description = "Nome medico",type = "string")
    private String nomeMedico;
    @Schema(description = "Cognome medico",type = "string")
    private String cognomeMedico;
    @Schema(description = "Nome medicinale",type = "string")
    private String nomeMedicinale;
    @Schema(description = "Nome paziente",type = "string")
    private String nomePaziente;
    @Schema(description = "Cognome medico",type = "string")
    private String cognomePaziente;
}
