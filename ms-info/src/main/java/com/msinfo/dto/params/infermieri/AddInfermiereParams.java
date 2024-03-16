package com.msinfo.dto.params.infermieri;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddInfermiereParams {
    @Schema(description = "Nome dell'infermiere da inserire",type = "string")
    private String nome;

    @Schema(description = "Cognome dell'infermiere da inserire",type = "string")
    private String cognome;

    @Schema(description = "Turno dell'infermiere da inserire",type = "string")
    private String turno;

    @Schema(description = "Profilo dell'infermiere da inserire",type = "integer")
    private Integer profilo;
}
