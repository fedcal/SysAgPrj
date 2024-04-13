package com.bff.dto.mspaziente.params.malattiacontroller;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AggiungiCartellaClinicaParams {
    @Schema(description = "Gruppo sanguigno",type = "string")
    private String gruppoSanguigno;
    @Schema(description = "Id del paziente relativo",type = "integer")
    private Integer idPaziente;
}
