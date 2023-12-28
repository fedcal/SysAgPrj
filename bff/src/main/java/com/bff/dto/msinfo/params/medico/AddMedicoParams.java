package com.bff.dto.msinfo.params.medico;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddMedicoParams {
    @Schema(description = "Nome del medico da aggiungere")
    private String nome;

    @Schema(description = "Cognome del medico da aggiungere")
    private String cognome;

    @Schema(description = "Turno del medico da aggiungere")
    private String turno;

    @Schema(description = "Profilo del medico da aggiungere")
    private Integer profilo;
}
