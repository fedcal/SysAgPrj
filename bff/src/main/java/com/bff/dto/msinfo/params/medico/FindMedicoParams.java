package com.bff.dto.msinfo.params.medico;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FindMedicoParams {
    @Schema(description = "Id del medico da trovare")
    private Integer idMedico;

    @Schema(description = "Nome del medico da trovare")
    private String nome;

    @Schema(description = "Cognome del medico da trovare")
    private String cognome;
}
