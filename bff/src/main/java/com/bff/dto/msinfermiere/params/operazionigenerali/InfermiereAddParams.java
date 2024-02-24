package com.bff.dto.msinfermiere.params.operazionigenerali;

import io.swagger.v3.oas.annotations.media.Schema;

public class InfermiereAddParams {
    @Schema(description = "Nome infermiere",type = "string")
    private String nome;
    @Schema(description = "Cognome infermiere",type = "string")
    private String cognome;
    @Schema(description = "Turno infermiere",type = "string")
    private String turno;
}
