package com.enciclopedia.dto.params.sintomo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SintomoParams {
    @Schema(description = "Nome sintomo",type = "string",example = "Abulia")
    private String nomeSintomo;

    @Schema(description = "Descrizione sintomo",type = "string",example = "Abulia")
    private String descrizioneSintomo;
}
