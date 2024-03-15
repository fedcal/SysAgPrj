package com.enciclopedia.dto.params.sintomo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SintomoInfoParams {
    @Schema(description = "Id sintomo",type = "integer")
    private Integer idSintomo;

    @Schema(description = "Nome sintomo",type = "string")
    private String nomeSintomo;
}
