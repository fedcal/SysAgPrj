package com.bff.dto.msenciclopedia.params.sintomo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SintomoParams {
    @Schema(description = "Nome sintomo")
    private String nomeSintomo;

    @Schema(description = "Descrizione sintomo")
    private String descrizioneSintomo;
}
