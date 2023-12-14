package com.msinfo.dto.params.reparto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RicercaRepartoParams {
    @Schema(description = "Id del reparto")
    private Integer idReparto;

    @Schema(description = "Nome del reparto")
    private String nomeReparto;
}
