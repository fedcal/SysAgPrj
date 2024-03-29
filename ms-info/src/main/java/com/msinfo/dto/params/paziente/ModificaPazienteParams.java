package com.msinfo.dto.params.paziente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ModificaPazienteParams {
    @Schema(description = "Id del paziente da modificare",type = "integer")
    private Integer idPazinente;

    @Schema(description = "Nuovo nome del paziente",type = "string")
    private String nuovoNome;

    @Schema(description = "Nuovo cognome del paziente",type = "string")
    private String nuovoCognome;

    @Schema(description = "Nuova data di nascita del paziente",type = "string")
    private String nuovaDataNascita;

    @Schema(description = "Nuovo luogo di nascita del paziente",type = "string")
    private String nuovoLuogoNascita;

    @Schema(description = "Nuova provincia di nascita del paziente",type = "string")
    private String nuovaProvinciaNascita;

    @Schema(description = "Nuovo contatto di riferimento del paziente",type = "integer")
    private Integer nuovoContattoRiferimentoId;

    @Schema(description = "Nuovo reparto nel quale viene curato il paziente",type = "integer")
    private Integer nuovoRepartoId;
}
