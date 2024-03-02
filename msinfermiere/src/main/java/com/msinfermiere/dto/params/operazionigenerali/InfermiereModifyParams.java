package com.msinfermiere.dto.params.operazionigenerali;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class InfermiereModifyParams {
    @Schema(description = "Id infermiere",type = "integer")
    private Integer idInfermiere;
    @Schema(description = "Nome infermiere da ricercare e da modificare",type = "string")
    private String nomeRicerca;
    @Schema(description = "Cognome infermiere da ricercare e da modificare",type = "string")
    private String cognomeRicerca;

    @Schema(description = "Nuovo nome dell'infermiere",type = "string")
    private String nuovoNome;
    @Schema(description = "Nuovo cognome dell'infermiere",type = "string")
    private String nuovoCognome;
    @Schema(description = "Nuovo turno dell'infermiere infermiere",type = "string")
    private String nuovoTurno;
}
