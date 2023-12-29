package com.bff.dto.msinfo.params.paziente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddPazienteParams {
    @Schema(description = "Nome paziente",type = "string",example = "Roberto")
    private String nome;

    @Schema(description = "Cognome paziente",type = "string",example = "Benigni")
    private String cognome;

    @Schema(description = "Data di nascita del paziente",type = "string",example = "1998-07-05")
    private String dataNascita;

    @Schema(description = "Luogo di nascita del paziente",type = "string",example = "Bari")
    private String luogoNascita;

    @Schema(description = "Provincia di nascita del paziente",type = "string",example = "Bari")
    private String provinciaNascita;

    @Schema(description = "Contatto di riferimento del paziente",type = "integer",example = "1")
    private Integer contattoRiferimentoId;

    @Schema(description = "Reparto nel quale si trova il paziente",type = "integer",example = "1")
    private Integer repartoId;
}
