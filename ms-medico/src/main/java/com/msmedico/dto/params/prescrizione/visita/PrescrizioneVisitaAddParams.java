package com.msmedico.dto.params.prescrizione.visita;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PrescrizioneVisitaAddParams {
    @Schema(description = "Id della visita medica",type = "integer")
    private Integer visitaMedica;
    @Schema(description = "Id della cartella clinica",type = "integer")
    private Integer cartellaClinica;
    @Schema(description = "Id del medico",type = "integer")
    private Integer medico;
}
