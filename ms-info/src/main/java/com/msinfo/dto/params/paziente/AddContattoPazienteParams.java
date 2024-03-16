package com.msinfo.dto.params.paziente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddContattoPazienteParams {
    @Schema(description = "Nome del contatto",type = "string")
    private String nome;
    @Schema(description = "Cognome del contatto",type = "string")
    private String cognome;
    @Schema(description = "Numero di cellulare",type = "string")
    private String numeroCellulare;
}
