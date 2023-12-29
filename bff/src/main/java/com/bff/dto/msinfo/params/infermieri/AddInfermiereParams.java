package com.bff.dto.msinfo.params.infermieri;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddInfermiereParams {
    @Schema(description = "Nome dell'infermiere da inserire",type = "string",example = "Francesco")
    private String nome;

    @Schema(description = "Cognome dell'infermiere da inserire",type = "string",example = "De Ceglie")
    private String cognome;

    @Schema(description = "Turno dell'infermiere da inserire",type = "string",example = "Lun. 08:30-16:30, Ven. 14:30-18:00")
    private String turno;

    @Schema(description = "Profilo dell'infermiere da inserire",type = "integer",example = "1")
    private Integer profilo;
}
