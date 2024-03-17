package com.msmedico.dto.params.prescrizione.medicinale;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PrescrizioneMedicinaleInfoParams {
    @Schema(description = "Id della relazione",type = "integer")
    private Integer idRelazione;

    @Schema(description = "Id del medico",type = "integer")
    private Integer idMedico;

    @Schema(description = "Id del medicinale",type = "integer")
    private Integer idMedicinale;

    @Schema(description = "Id della cartella clinica",type = "integer")
    private Integer idCartellaClinica;

    @Schema(description = "Id del paziente",type = "integer")
    private Integer idPaziente;

    @Schema(description = "Nome del medico",type = "string")
    private String nomeMedico;

    @Schema(description = "Cognome del medico",type = "string")
    private String cognomeMedico;

    @Schema(description = "Nome del paziente",type = "string")
    private String nomePaziente;

    @Schema(description = "Cognome del paziente",type = "string")
    private String cognomePaziente;

    @Schema(description = "Nome del medicinale",type = "string")
    private String nomeMedicinale;
}
