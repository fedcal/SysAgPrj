package com.msinfermiere.dto.params.messaggimedico;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class InfermiereMedicoMessaggioDto {
    @Schema(description = "Messaggio da inviare",type = "string",example = "Ciao")
    private String messaggio;
    @Schema(description = "Livello di urgenza del messaggio",type = "string",example = "Ciao")
    private String livelloUrgenza;
}
