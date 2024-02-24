package com.bff.dto.msinfermiere.params;

import io.swagger.v3.oas.annotations.media.Schema;

public class PazienteFiltratiParams {
    @Schema(description = "Id del paziente",type = "int")
    private Integer idPaziente;

    @Schema(description = "Nome del paziente",type = "string")
    private String nome;
    @Schema(description = "Cognome del paziente",type = "string")
    private String cognome;
}
