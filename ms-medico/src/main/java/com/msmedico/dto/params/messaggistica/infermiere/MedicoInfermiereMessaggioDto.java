package com.msmedico.dto.params.messaggistica.infermiere;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MedicoInfermiereMessaggioDto {
    @Schema(description = "Messaggio da inviare",type = "string",example = "Ciao")
    private String messaggio;
    @Schema(description = "Livello di urgenza del messaggio",type = "string",example = "LOW")
    private String livelloUrgenza;
}
