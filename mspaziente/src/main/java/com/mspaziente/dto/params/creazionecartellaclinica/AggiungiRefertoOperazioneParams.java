package com.mspaziente.dto.params.creazionecartellaclinica;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AggiungiRefertoOperazioneParams {
    @Schema(description = "Tipologia referto operazione",type = "string")
    private String tipologia;
    @Schema(description = "Descrizione referto operazionne",type = "string")
    private String descrizione;
    @Schema(description = "Data referto",type = "strinng")
    private String dataReferto;
}
