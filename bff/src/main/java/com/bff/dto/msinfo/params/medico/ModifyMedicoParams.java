package com.bff.dto.msinfo.params.medico;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ModifyMedicoParams {
    @Schema(description = "Id del medico da modificare")
    private Integer idMedico;

    @Schema(description = "Nuovo nome")
    private String nuovoNome;

    @Schema(description = "Nuovo cognome")
    private String nuovoCognome;

    @Schema(description = "Nuovo turno")
    private String nuovoTurno;

    @Schema(description = "Nuovo profilo")
    private Integer nuovoProfilo;
}
