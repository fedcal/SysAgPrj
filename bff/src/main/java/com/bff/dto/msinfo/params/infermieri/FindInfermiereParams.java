package com.bff.dto.msinfo.params.infermieri;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FindInfermiereParams {
    @Schema(description = "Id infermiere da eliminare",type = "integer",example = "1")
    private Integer idInfermiere;

    @Schema(description = "Nome infermiere da eliminare",type = "string",example = "Francesco")
    private String nomeInfermiere;

    @Schema(description = "Cognome infermiere da eliminare",type = "string",example = "De Ceglie")
    private String cognomeInfermiere;
}
