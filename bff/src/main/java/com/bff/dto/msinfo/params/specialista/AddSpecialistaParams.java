package com.bff.dto.msinfo.params.specialista;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddSpecialistaParams {
    @Schema(description = "Nome dello specialista da inserire",type = "string",example = "Mario")
    private String nome;

    @Schema(description = "Cognome dello specialista da inserire",type = "string",example = "Rossi")
    private String cognome;

    @Schema(description = "Specializzazione dello specialista da inserire",type = "string",example = "Anestesia")
    private String specializzazione;

    @Schema(description = "Turno dello specialista da inserire",type = "string",example = "Lun.. 15:00-00:00")
    private String turno;

    @Schema(description = "Profilo dello specialista da inserire",type = "integer",example = "1")
    private Integer profilo;
}
