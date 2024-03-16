package com.msinfo.dto.params.profilo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddProfiloParams {
    @Schema(description = "Tipo del profilo da aggiungere",type = "string")
    private String tipo;

    @Schema(description = "Tipo del profilo da aggiungere",type = "string")
    private String descrizione;
}
