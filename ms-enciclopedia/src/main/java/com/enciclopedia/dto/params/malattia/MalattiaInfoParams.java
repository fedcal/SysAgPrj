package com.enciclopedia.dto.params.malattia;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MalattiaInfoParams {
    @Schema(description = "Id malattia",type = "integer")
    private Integer idMalattia;

    @Schema(description = "Nome malattia",type = "string")
    private String nomeMalattia;
}
