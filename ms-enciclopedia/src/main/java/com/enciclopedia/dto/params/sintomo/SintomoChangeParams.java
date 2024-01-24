package com.enciclopedia.dto.params.sintomo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SintomoChangeParams {
    @Schema(description = "Id sintomo",type = "integer",example = "1")
    private Integer idSintomo;

    @Schema(description = "Nome sintomo",type = "string",example = "Abulia")
    private String nomeSintomo;

    @Schema(description = "Nuova descrizione",type = "string",example = "Abulia")
    private String descrizioneNuova;

    @Schema(description = "Nuovo nome",type = "string",example = "Abulia")
    private String nomeSintomoNuovo;
}
