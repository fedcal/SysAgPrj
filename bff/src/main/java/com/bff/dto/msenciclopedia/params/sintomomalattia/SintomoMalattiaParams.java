package com.bff.dto.msenciclopedia.params.sintomomalattia;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SintomoMalattiaParams {
    @Schema(description = "Id sintomo")
    private Integer idSintomo;

    @Schema(description = "Id malattia")
    private Integer idMalattia;
}
