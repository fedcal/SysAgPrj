package com.msinfo.dto.params.paziente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddPazienteParams {
    @Schema(description = "Nome paziente",type = "string")
    private String nome;

    @Schema(description = "Cognome paziente",type = "string")
    private String cognome;

    @Schema(description = "Data di nascita del paziente",type = "string")
    private String dataNascita;

    @Schema(description = "Luogo di nascita del paziente",type = "string")
    private String luogoNascita;

    @Schema(description = "Provincia di nascita del paziente",type = "string")
    private String provinciaNascita;

    @Schema(description = "Contatto di riferimento del paziente",type = "integer")
    private Integer contattoRiferimentoId;

    @Schema(description = "Reparto nel quale si trova il paziente",type = "integer")
    private Integer repartoId;
}
