package com.bff.dto.msmedico.params.gestionemedici;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddMedicoParams {
    @Schema(description = "Nome del medico da aggiungere",type = "string",example = "Roberto")
    private String nome;

    @Schema(description = "Cognome del medico da aggiungere",type = "string",example = "Benigni")
    private String cognome;

    @Schema(description = "Turno del medico da aggiungere",type = "string",example = "Lun. 08:30-16:30")
    private String turno;

    @Schema(description = "Profilo del medico da aggiungere",type = "integer",example = "1")
    private Integer profilo;
}
