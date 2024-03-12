package com.mspaziente.dto.params.creazionecartellaclinica;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AggiungiRefertoVisitaMedicaParams {
    @Schema(description = "Descrizione referto",type = "string")
    private String descrizione;
    @Schema(description = "Tipologia referto",type = "string")
    private String tipologia;
    @Schema(description = "Data referto",type = "string")
    private String dataReferto;
}
