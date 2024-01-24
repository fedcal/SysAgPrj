package com.enciclopedia.dto.params.sintomomalattia;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SintomoMalattiaParams {
    @Schema(description = "Id relazione",type = "integer",example = "1")
    private Integer idRelazione;

    @Schema(description = "Id sintomo",type = "integer",example = "1")
    private Integer idSintomo;

    @Schema(description = "Id malattia",type = "integer",example = "1")
    private Integer idMalattia;
}
