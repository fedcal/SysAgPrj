package com.msinfermiere.dto.params.operazionigenerali;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class InfermiereDeleteParams {
    @Schema(description = "Id infermiere",type = "int")
    private Integer id;
    @Schema(description = "Nome infermiere",type = "string")
    private String nome;
    @Schema(description = "Cognome infermiere",type = "string")
    private String cognome;
}
