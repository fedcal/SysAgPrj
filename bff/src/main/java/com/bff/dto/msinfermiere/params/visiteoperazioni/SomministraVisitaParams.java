package com.bff.dto.msinfermiere.params.visiteoperazioni;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SomministraVisitaParams {
    @Schema(description = "Id infermiere",type = "int")
    private Integer idInfermiere;
    @Schema(description = "Id visita",type = "int")
    private Integer idVisita;
    @Schema(description = "Id cartella clinica",type = "int")
    private Integer idCartellaClinica;
}
