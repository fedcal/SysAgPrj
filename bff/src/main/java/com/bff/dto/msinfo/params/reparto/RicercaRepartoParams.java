package com.bff.dto.msinfo.params.reparto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RicercaRepartoParams {
    @Schema(description = "Id del reparto",type = "integer",example = "1")
    private Integer idReparto;

    @Schema(description = "Nome del reparto",type = "string",example = "Chirurgia")
    private String nomeReparto;
}
