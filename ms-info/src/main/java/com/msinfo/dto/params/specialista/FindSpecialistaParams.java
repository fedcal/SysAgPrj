package com.msinfo.dto.params.specialista;

import com.msinfo.dto.ProfiloDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FindSpecialistaParams {
    @Schema(description = "Id dello specialista da trovare",type = "integer",example = "1")
    private Integer idSpecialista;

    @Schema(description = "Nome dello specialista da trovare",type = "string",example = "Mario")
    private String nome;

    @Schema(description = "Cognome dello specialista da trovare",type = "string",example = "Rossi")
    private String cognome;
}
