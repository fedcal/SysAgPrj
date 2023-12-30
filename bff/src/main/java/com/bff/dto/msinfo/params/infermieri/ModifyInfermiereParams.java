package com.bff.dto.msinfo.params.infermieri;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ModifyInfermiereParams {
    @Schema(description = "Id infermiere da modificare",type = "integer",example = "1")
    private Integer idInfermiere;

    @Schema(description = "Nuovo nome",type = "string",example = "Ferdinando")
    private String nuovoNome;

    @Schema(description = "Nuovo cognome",type = "string",example = "Del Bosco")
    private String nuovoCognome;

    @Schema(description = "Nuovo turno",type = "string",example = "Lun. 08:30-16:30")
    private String nuovoTurno;

    @Schema(description = "Nuovo profilo",type = "integer",example = "1")
    private Integer nuovoProfilo;
}
