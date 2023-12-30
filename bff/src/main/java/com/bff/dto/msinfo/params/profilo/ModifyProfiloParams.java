package com.bff.dto.msinfo.params.profilo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ModifyProfiloParams {
    @Schema(description = "Id del profilo da aggiornare",type = "integer",example = "1")
    private Integer idProfilo;

    @Schema(description = "Nuovo tipo di profilo",type = "string",example = "Medico")
    private String nuovoTipo;

    @Schema(description = "Nuova descrizione del profilo",type = "string",example = "Medico presente nella struttura")
    private String nuovaDescrizione;
}
