package com.bff.dto.msinfo.params.specialista;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddSpecialistaParams {
    @Schema(description = "Nome dello specialista da inserire")
    private String nome;

    @Schema(description = "Cognome dello specialista da inserire")
    private String cognome;

    @Schema(description = "Specializzazione dello specialista da inserire")
    private String specializzazione;

    @Schema(description = "Turno dello specialista da inserire")
    private String turno;

    @Schema(description = "Profilo dello specialista da inserire")
    private Integer profilo;
}
