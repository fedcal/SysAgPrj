package com.bff.dto.msinfo.params.specialista;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FindSpecialistaParams {
    @Schema(description = "Id dello specialista da trovare")
    private Integer idSpecialista;

    @Schema(description = "Nome dello specialista da trovare")
    private String nome;

    @Schema(description = "Cognome dello specialista da trovare")
    private String cognome;
}
