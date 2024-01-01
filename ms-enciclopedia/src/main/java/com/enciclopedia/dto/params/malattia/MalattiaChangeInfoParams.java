package com.enciclopedia.dto.params.malattia;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MalattiaChangeInfoParams {
    @Schema(description = "Nome malattia",type = "string",example = "Acalasia")
    private String nome;

    @Schema(description = "Id malattia",type = "integer",example = "1")
    private Integer id;

    @Schema(description = "Nome nuovo della malattia",type = "string",example = "Acalasia")
    private String nuovoNome;

    @Schema(description = "Descrizione nuova della malattia",type = "string",example = "Acalasia")
    private String nuovaDescrizione;
}
