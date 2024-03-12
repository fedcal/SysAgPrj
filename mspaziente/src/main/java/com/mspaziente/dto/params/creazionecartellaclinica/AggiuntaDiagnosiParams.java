package com.mspaziente.dto.params.creazionecartellaclinica;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AggiuntaDiagnosiParams {
    @Schema(description = "Id cartella clinica",type = "integer")
    private Integer idCartellaClinica;

    @Schema(description = "Tipo diagnosi",type = "string")
    private String tipoDiagnosi;
    @Schema(description = "Descrizionne diagnosi",type = "string")
    private String descrizione;
}
