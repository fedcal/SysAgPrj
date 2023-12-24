package com.msinfo.dto.params.paziente;

import com.msinfo.dto.ContattoRiferimentoDto;
import com.msinfo.dto.ProfiloDto;
import com.msinfo.dto.RepartoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddPazienteParams {
    @Schema(description = "Nome paziente")
    private String nome;

    @Schema(description = "Cognome paziente")
    private String cognome;

    @Schema(description = "Data di nascita del paziente")
    private String dataNascita;

    @Schema(description = "Luogo di nascita del paziente")
    private String luogoNascita;

    @Schema(description = "Provincia di nascita del paziente")
    private String provinciaNascita;

    @Schema(description = "Contatto di riferimento del paziente")
    private Integer contattoRiferimentoId;

    @Schema(description = "Reparto nel quale si trova il paziente")
    private Integer repartoId;
}
