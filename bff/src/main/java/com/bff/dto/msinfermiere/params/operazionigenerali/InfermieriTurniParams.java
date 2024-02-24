package com.bff.dto.msinfermiere.params.operazionigenerali;

import io.swagger.v3.oas.annotations.media.Schema;

public class InfermieriTurniParams {
    @Schema(description = "Turno",type = "string")
    private String turno;
}
