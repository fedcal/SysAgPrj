package com.msmedico.dto.params.gestionemedici;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ModifyMedicoParams {
    @Schema(description = "Id del medico da modificare",type = "integer")
    private Integer idMedico;

    @Schema(description = "Nuovo nome",type = "string")
    private String nuovoNome;

    @Schema(description = "Nuovo cognome",type = "string")
    private String nuovoCognome;

    @Schema(description = "Nuovo turno",type = "string")
    private String nuovoTurno;

    @Schema(description = "Nuovo profilo",type = "integer")
    private Integer nuovoProfilo;
}
