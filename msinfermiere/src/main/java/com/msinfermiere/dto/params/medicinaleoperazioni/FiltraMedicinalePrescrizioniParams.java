package com.msinfermiere.dto.params.medicinaleoperazioni;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FiltraMedicinalePrescrizioniParams {
    @Schema(description = "Id prescrizione medicinale",type = "integer")
    private Integer idPrescrizioneMedicinale;
    @Schema(description = "Id medico",type = "integer")
    private Integer idMedico;
    @Schema(description = "Id medicinale",type = "integer")
    private Integer idMedicinale;
    @Schema(description = "Id cartella clinica",type = "integer")
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
