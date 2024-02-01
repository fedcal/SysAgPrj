package com.bff.dto.msmedico.params.visualizzastato;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FindCartellaClinicaParams {
    @Schema(description = "Id della cartella clinica da ricercare",type = "integer")
    private Integer idCartellaClinica;

    @Schema(description = "Id del paziente",type = "integer")
    private Integer idPaziente;

    @Schema(description = "Nome del paziente",type = "string")
    private String nome;

    @Schema(description = "Cognome del paziente",type = "string")
    private String cognome;
}
