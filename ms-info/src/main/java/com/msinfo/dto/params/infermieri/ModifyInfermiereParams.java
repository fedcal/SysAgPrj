package com.msinfo.dto.params.infermieri;

import com.msinfo.dto.ProfiloDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ModifyInfermiereParams {
    @Schema(description = "Id infermiere da modificare")
    private Integer idInfermiere;

    @Schema(description = "Nuovo nome")
    private String nuovoNome;

    @Schema(description = "Nuovo cognome")
    private String nuovoCognome;

    @Schema(description = "Nuovo turno")
    private String nuovoTurno;

    @Schema(description = "Nuovo profilo")
    private Integer nuovoProfilo;
}
