package com.bff.dto.msenciclopedia.params.sintomomalattia;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SintomoMalattiaChangeParams {
    @Schema(description = "Id relazione")
    private Integer idRelazione;

    @Schema(description = "Id Malattia")
    private Integer idMalattia;

    @Schema(description = "Id sintomo")
    private Integer idSintomo;

    @Schema(description = "Nuovo id malattia")
    private Integer newIdMalattia;

    @Schema(description = "Nuovo id sintomo")
    private Integer newIdSitnomo;
}
