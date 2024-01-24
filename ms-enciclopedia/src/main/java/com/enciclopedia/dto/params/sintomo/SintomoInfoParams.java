package com.enciclopedia.dto.params.sintomo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SintomoInfoParams {
    @Schema(description = "Id sintomo",type = "integer",example = "2")
    private Integer idSintomo;

    @Schema(description = "Nome sintomo",type = "string",example = "Abulia")
    private String nomeSintomo;
}
