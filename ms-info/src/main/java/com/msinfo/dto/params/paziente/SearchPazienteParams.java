package com.msinfo.dto.params.paziente;

import com.msinfo.dto.ContattoRiferimentoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SearchPazienteParams {
    @Schema(description = "Id del paziente", example = "1",type = "integer")
    private Integer idPaziente;

    @Schema(description = "Nome del paziente", example = "Federico",type = "string")
    private String nome;

    @Schema(description = "Cognome del paziente", example = "Calò",type = "string")
    private String cognome;

    @Schema(description = "Data di nascita del paziente nel formato: aaaa/mm/dd", example = "1998/05/07",type = "string")
    private String dataNascita;

    @Schema(description = "Nome del reparto del paziente", example = "Medicina Generale",type = "string")
    private String nomeReparto;

    @Schema(description = "Contatto di riferimento del paziente",type = "integer")
    private Integer contattoRiferimentoDto;
}
