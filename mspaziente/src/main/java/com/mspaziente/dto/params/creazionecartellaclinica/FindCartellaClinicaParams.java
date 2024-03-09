package com.mspaziente.dto.params.creazionecartellaclinica;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FindCartellaClinicaParams {
    @Schema(description = "Messaggio da inviare",type = "integer",example = "1")
    private Integer idCartellaClinica;
}
