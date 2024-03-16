package com.msinfo.dto.params.specialista;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddSpecialistaParams {
    @Schema(description = "Nome dello specialista da inserire",type = "string")
    private String nome;

    @Schema(description = "Cognome dello specialista da inserire",type = "string")
    private String cognome;

    @Schema(description = "Specializzazione dello specialista da inserire",type = "string")
    private String specializzazione;

    @Schema(description = "Turno dello specialista da inserire",type = "string")
    private String turno;

    @Schema(description = "Profilo dello specialista da inserire",type = "integer")
    private Integer profilo;
}
