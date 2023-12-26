package com.msinfo.dto.params.infermieri;

import com.msinfo.dto.ProfiloDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddInfermiere {
    @Schema(description = "Nome dell'infermiere da inserire")
    private String nome;

    @Schema(description = "Cognome dell'infermiere da inserire")
    private String cognome;

    @Schema(description = "Turno dell'infermiere da inserire")
    private String turno;

    @Schema(description = "Profilo dell'infermiere da inserire")
    private Integer profilo;
}
