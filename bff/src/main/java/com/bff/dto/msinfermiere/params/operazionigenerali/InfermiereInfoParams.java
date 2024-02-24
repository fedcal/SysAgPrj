package com.bff.dto.msinfermiere.params.operazionigenerali;

import io.swagger.v3.oas.annotations.media.Schema;

public class InfermiereInfoParams {
    @Schema(description = "Id infermiere",type = "int")
    private Integer id;
    @Schema(description = "Nome infermiere",type = "string")
    private String nomeInfermiere;
    @Schema(description = "Cognome infermiere",type = "string")
    private String cognomeInfermiere;
}
