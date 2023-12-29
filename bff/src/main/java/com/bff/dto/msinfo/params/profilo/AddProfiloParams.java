package com.bff.dto.msinfo.params.profilo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddProfiloParams {
    @Schema(description = "Tipo del profilo da aggiungere",type = "string",example = "Medico")
    private String tipo;

    @Schema(description = "Tipo del profilo da aggiungere",type = "string",example = "Medico presente nella struttura")
    private String descrizione;
}
