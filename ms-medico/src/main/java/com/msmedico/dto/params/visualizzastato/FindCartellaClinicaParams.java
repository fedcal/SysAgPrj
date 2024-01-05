package com.msmedico.dto.params.visualizzastato;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FindCartellaClinicaParams {
    @Schema(description = "Id della cartella clinica da ricercare",type = "integer")
    Integer idCartellaClinica;

    @Schema(description = "Id del paziente",type = "integer")
    Integer idPaziente;

    @Schema(description = "Nome del paziente",type = "string")
    String nome;

    @Schema(description = "Cognome del paziente",type = "string")
    String cognome;
}
