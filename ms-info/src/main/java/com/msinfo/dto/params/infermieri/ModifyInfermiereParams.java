package com.msinfo.dto.params.infermieri;

import com.msinfo.dto.ProfiloDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ModifyInfermiereParams {
    @Schema(description = "Id infermiere da modificare",type = "integer")
    private Integer idInfermiere;

    @Schema(description = "Nuovo nome",type = "string")
    private String nuovoNome;

    @Schema(description = "Nuovo cognome",type = "string")
    private String nuovoCognome;

    @Schema(description = "Nuovo turno",type = "string")
    private String nuovoTurno;

    @Schema(description = "Nuovo profilo",type = "integer")
    private Integer nuovoProfilo;
}
