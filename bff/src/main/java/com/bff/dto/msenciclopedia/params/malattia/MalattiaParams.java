package com.bff.dto.msenciclopedia.params.malattia;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MalattiaParams {
    @Schema(description = "Nome malattia")
    private String nome;

    @Schema(description = "Descrizione malattia")
    private String descrizione;
}
