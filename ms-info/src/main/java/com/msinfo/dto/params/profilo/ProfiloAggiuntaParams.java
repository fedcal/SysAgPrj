package com.msinfo.dto.params.profilo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProfiloAggiuntaParams {
    @Schema(description = "Tipo del profilo da aggiungere")
    private String tipo;

    @Schema(description = "Tipo del profilo da aggiungere")
    private String descrizione;
}
