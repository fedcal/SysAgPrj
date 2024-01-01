package com.enciclopedia.dto.params.malattia;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MalattiaInfoParams {
    @Schema(description = "Id malattia",type = "integer",example = "1")
    private Integer idMalattia;

    @Schema(description = "Nome malattia",type = "string",example = "Acalasia")
    private String nomeMalattia;
}
