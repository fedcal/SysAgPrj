package com.bff.dto.mspaziente.params.malattiacontroller;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AggiungiMalattiaParams {
    @Schema(description = "Id cartella clinica",type = "integer")
    private Integer idCartellaClinica;
    @Schema(description = "Id malattia",type = "integer")
    private Integer idMalattia;
}
