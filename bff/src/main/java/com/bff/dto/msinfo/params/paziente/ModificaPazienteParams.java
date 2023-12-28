package com.bff.dto.msinfo.params.paziente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ModificaPazienteParams {
    @Schema(description = "Id del paziente da modificare")
    private Integer idPazinente;

    @Schema(description = "Nuovo nome del paziente")
    private String nuovoNome;

    @Schema(description = "Nuovo cognome del paziente")
    private String nuovoCognome;

    @Schema(description = "Nuova data di nascita del paziente")
    private String nuovaDataNascita;

    @Schema(description = "Nuovo luogo di nascita del paziente")
    private String nuovoLuogoNascita;

    @Schema(description = "Nuova provincia di nascita del paziente")
    private String nuovaProvinciaNascita;

    @Schema(description = "Nuovo contatto di riferimento del paziente")
    private Integer nuovoContattoRiferimentoId;

    @Schema(description = "Nuovo reparto nel quale viene curato il paziente")
    private Integer nuovoRepartoId;
}
