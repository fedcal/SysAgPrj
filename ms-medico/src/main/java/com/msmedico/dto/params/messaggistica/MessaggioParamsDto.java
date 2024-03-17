package com.msmedico.dto.params.messaggistica;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MessaggioParamsDto {
    @Schema(description = "Messaggio da inviare",type = "string")
    private String messaggio;
    @Schema(description = "Livello di urgenza del messaggio",type = "string")
    private String livelloUrgenza;
}
