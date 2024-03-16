package com.msinfo.dto.params.reparto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RicercaRepartoParams {
    @Schema(description = "Id del reparto",type = "integer")
    private Integer idReparto;

    @Schema(description = "Nome del reparto",type = "string")
    private String nomeReparto;
}
