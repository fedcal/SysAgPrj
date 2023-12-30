package com.bff.dto.msinfo.params.medico;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ModifyMedicoParams {
    @Schema(description = "Id del medico da modificare",type = "integer",example = "1")
    private Integer idMedico;

    @Schema(description = "Nuovo nome",type = "string",example = "Roberto")
    private String nuovoNome;

    @Schema(description = "Nuovo cognome",type = "string",example = "Benigni")
    private String nuovoCognome;

    @Schema(description = "Nuovo turno",type = "string",example = "Lun. 08:30-16:30")
    private String nuovoTurno;

    @Schema(description = "Nuovo profilo",type = "integer",example = "1")
    private Integer nuovoProfilo;
}
