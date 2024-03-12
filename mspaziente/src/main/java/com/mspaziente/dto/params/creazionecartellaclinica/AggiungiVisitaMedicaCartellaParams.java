package com.mspaziente.dto.params.creazionecartellaclinica;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AggiungiVisitaMedicaCartellaParams {
    @Schema(description = "Id visita medica",type = "integer")
    private Integer idVisitaMedica;
    @Schema(description = "Id cartella clinica",type = "integer")
    private Integer idCartellaClinica;
    @Schema(description = "Id referto",type = "integer")
    private Integer idReferto;
}
