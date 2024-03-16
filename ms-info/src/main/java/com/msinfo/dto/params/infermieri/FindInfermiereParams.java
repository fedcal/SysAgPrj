package com.msinfo.dto.params.infermieri;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FindInfermiereParams {
    @Schema(description = "Id infermiere da eliminare",type = "integer")
    private Integer idInfermiere;

    @Schema(description = "Nome infermiere da eliminare",type = "string")
    private String nomeInfermiere;

    @Schema(description = "Cognome infermiere da eliminare",type = "string")
    private String cognomeInfermiere;
}
