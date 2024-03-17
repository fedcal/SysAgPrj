package com.msmedico.dto.params.prescrizione.visita;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PrescrizioneVisitaInfoParams {
    @Schema(description = "Id della relazione",type = "integer")
    private Integer idRelazione;
    @Schema(description = "Id del medico",type = "integer")
    private Integer idMedico;
    @Schema(description = "Id della cartella medica",type = "integer")
    private Integer idCartella;
    @Schema(description = "Id della visita medica",type = "integer")
    private Integer idVisita;
    @Schema(description = "Id del paziente",type = "integer")
    private Integer idPaziente;

    @Schema(description = "Nome visita medica",type = "string")
    private String nomeVisita;
    @Schema(description = "Nome medico",type = "string")
    private String nomeMedico;
    @Schema(description = "Cognome medico",type = "string")
    private String cognomeMedico;
    @Schema(description = "Nome paziente",type = "string")
    private String nomePaziente;
    @Schema(description = "Cognome paziente",type = "string")
    private String cognomePaziente;
}
