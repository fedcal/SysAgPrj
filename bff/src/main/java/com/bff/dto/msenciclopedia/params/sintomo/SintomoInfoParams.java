package com.bff.dto.msenciclopedia.params.sintomo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SintomoInfoParams {
    @Schema(description = "Id sintomo")
    private Integer idSintomo;

    @Schema(description = "Nome sintomo")
    private String nomeSintomo;
}
