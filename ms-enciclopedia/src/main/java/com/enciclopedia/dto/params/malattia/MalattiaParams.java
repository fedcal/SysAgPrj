package com.enciclopedia.dto.params.malattia;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MalattiaParams {
    @Schema(description = "Nome malattia",type = "string",example = "Acalasia")
    private String nome;

    @Schema(description = "Descrizione malattia",type = "string",example = "Acalasia")
    private String descrizione;
}
