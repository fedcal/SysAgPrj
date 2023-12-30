package com.bff.dto.msenciclopedia.params.malattia;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MalattiaInfoParams {
    @Schema(description = "Id malattia")
    private Integer idMalattia;

    @Schema(description = "Nome malattia")
    private String nomeMalattia;
}
