package com.bff.dto.msenciclopedia.params.malattia;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MalattiaChangeInfoParams {
    @Schema(description = "Nome malattia")
    private String nome;

    @Schema(description = "Id malattia")
    private Integer id;

    @Schema(description = "Nome nuovo della malattia")
    private String nuovoNome;

    @Schema(description = "Descrizione nuova della malattia")
    private String nuovaDescrizione;
}
