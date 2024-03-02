package com.bff.dto.msinfermiere.params.visiteoperazioni;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FiltraVisiteSottoministrateInfermieriParams {
    @Schema(description = "Id sottoministrazione",type = "int")
    private Integer idSottoministrazione;
    @Schema(description = "Id infermiere",type = "int")
    private Integer idInfermiere;
    @Schema(description = "Id visita",type = "int")
    private Integer idVisita;
    @Schema(description = "Id cartella clinica",type = "int")
    private Integer idCartellaClinica;

    @Schema(description = "Nome infermiere",type = "string")
    private String nomeInfermiere;
    @Schema(description = "Cognome infermiere",type = "string")
    private String cognomeInfermiere;
    @Schema(description = "Nome visita",type = "string")
    private String nomeVisita;
    @Schema(description = "Nome paziente",type = "string")
    private String nomePaziente;
    @Schema(description = "Cognome paziente",type = "string")
    private String cognomePaziente;
}
