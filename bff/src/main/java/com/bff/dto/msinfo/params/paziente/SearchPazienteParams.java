package com.bff.dto.msinfo.params.paziente;

import com.bff.dto.msinfo.ContattoRiferimentoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SearchPazienteParams {
    @Schema(description = "Id del paziente", example = "1")
    private Integer idPaziente;

    @Schema(description = "Nome del paziente", example = "Federico")
    private String nome;

    @Schema(description = "Cognome del paziente", example = "Calò")
    private String cognome;

    @Schema(description = "Data di nascita del paziente nel formato: aaaa/mm/dd", example = "1998/05/07")
    private String dataNascita;

    @Schema(description = "Nome del reparto del paziente", example = "Medicina Generale")
    private String nomeReparto;

    @Schema(description = "Contatto di riferimento del paziente")
    private ContattoRiferimentoDto contattoRiferimentoDto;
}
