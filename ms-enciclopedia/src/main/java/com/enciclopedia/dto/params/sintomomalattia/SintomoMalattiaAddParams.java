package com.enciclopedia.dto.params.sintomomalattia;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SintomoMalattiaAddParams {
    @Schema(description = "Id sintomo",type = "integer")
    private Integer idSintomo;

    @Schema(description = "Id malattia",type = "integer")
    private Integer idMalattia;
}
