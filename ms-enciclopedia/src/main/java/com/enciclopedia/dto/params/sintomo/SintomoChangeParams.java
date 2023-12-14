package com.enciclopedia.dto.params.sintomo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SintomoChangeParams {
    @Schema(description = "Id sintomo")
    private Integer idSintomo;

    @Schema(description = "Nome sintomo")
    private String nomeSintomo;

    @Schema(description = "Nuova descrizione")
    private String descrizioneNuova;

    @Schema(description = "Nuovo nome")
    private String nomeSintomoNuovo;
}
