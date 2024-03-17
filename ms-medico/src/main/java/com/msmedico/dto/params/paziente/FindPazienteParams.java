package com.msmedico.dto.params.paziente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FindPazienteParams {
    @Schema(description = "Id del paziente",type = "integer")
    private Integer idPaziente;
    @Schema(description = "Nome del paziente",type = "string")
    private String nome;
    @Schema(description = "Cognome del paziente",type = "string")
    private String cognome;
    @Schema(description = "Data di nascita",type = "string")
    private String dataNascita;
}
