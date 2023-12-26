package com.msinfo.dto.params.profilo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ModifyProfiloParams {
    @Schema(description = "Id del profilo da aggiornare")
    private Integer idProfilo;

    @Schema(description = "Nuovo tipo di profilo")
    private String nuovoTipo;

    @Schema(description = "Nuova descrizione del profilo")
    private String nuovaDescrizione;
}
