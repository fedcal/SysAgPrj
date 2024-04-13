package com.bff.dto.mspaziente.params.malattiacontroller;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AggiungiMedicinaleParams {
    @Schema(description = "Id cartella clinica",type = "integer")
    private Integer idCartellaClinica;
    @Schema(description = "Id medicinale",type = "integer")
    private Integer idMedicinale;
}
