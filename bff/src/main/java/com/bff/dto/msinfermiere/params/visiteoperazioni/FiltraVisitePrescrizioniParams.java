package com.bff.dto.msinfermiere.params.visiteoperazioni;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FiltraVisitePrescrizioniParams {
    @Schema(description = "Id prescrizione medicinale",type = "int")
    private Integer idPrescrizioneMedicinale;
    @Schema(description = "Id medico",type = "int")
    private Integer idMedico;
    @Schema(description = "Id visita",type = "int")
    private Integer idVisita;
    @Schema(description = "Id cartella clinica",type = "int")
    private Integer idCartellaClinica;

    @Schema(description = "Nome medico",type = "string")
    private String nomeMedico;
    @Schema(description = "Cognome medico",type = "string")
    private String cognomeMedico;
    @Schema(description = "Nome visita",type = "string")
    private String nomeVisita;
    @Schema(description = "Nome paziente",type = "string")
    private String nomePaziente;
    @Schema(description = "Cognome paziente",type = "string")
    private String cognomePaziente;
}
