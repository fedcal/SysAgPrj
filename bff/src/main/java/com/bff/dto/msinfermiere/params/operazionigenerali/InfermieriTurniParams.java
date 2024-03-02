package com.bff.dto.msinfermiere.params.operazionigenerali;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class InfermieriTurniParams {
    @Schema(description = "Turno",type = "string")
    private String turno;
}
