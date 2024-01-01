package com.enciclopedia.dto.params.sintomomalattia;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SintomoMalattiaChangeParams {
    @Schema(description = "Id relazione",type = "integer",example = "1")
    private Integer idRelazione;

    @Schema(description = "Id Malattia",type = "integer",example = "1")
    private Integer idMalattia;

    @Schema(description = "Id sintomo",type = "integer",example = "1")
    private Integer idSintomo;

    @Schema(description = "Nuovo id malattia",type = "integer",example = "1")
    private Integer newIdMalattia;

    @Schema(description = "Nuovo id sintomo",type = "integer",example = "1")
    private Integer newIdSitnomo;
}
