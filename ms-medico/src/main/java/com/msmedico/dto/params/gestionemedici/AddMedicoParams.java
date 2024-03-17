package com.msmedico.dto.params.gestionemedici;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddMedicoParams {
    @Schema(description = "Nome del medico da aggiungere",type = "string")
    private String nome;

    @Schema(description = "Cognome del medico da aggiungere",type = "string")
    private String cognome;

    @Schema(description = "Turno del medico da aggiungere",type = "string")
    private String turno;

    @Schema(description = "Profilo del medico da aggiungere",type = "integer")
    private Integer profilo;
}
