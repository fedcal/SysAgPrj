package com.msmedico.dto.params.gestionemedici;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FindMedicoParams {
    @Schema(description = "Id del medico da trovare",type = "integer",example = "1")
    private Integer idMedico;

    @Schema(description = "Nome del medico da trovare",type = "string",example = "Roberto")
    private String nome;

    @Schema(description = "Cognome del medico da trovare",type = "string",example = "Benigni")
    private String cognome;
}
