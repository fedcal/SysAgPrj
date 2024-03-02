package com.bff.dto.msinfermiere.params.operazionigenerali;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class InfermieriFiltatiParams {
    @Schema(description = "Nome dell'infermiere da filtrare",type = "string")
    private String nome;
    @Schema(description = "Cognome dell'infermiere da filtrare",type = "string")
    private String cognome;
}
