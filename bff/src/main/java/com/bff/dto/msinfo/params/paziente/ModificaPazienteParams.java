package com.bff.dto.msinfo.params.paziente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ModificaPazienteParams {
    @Schema(description = "Id del paziente da modificare",type = "integer",example = "1")
    private Integer idPazinente;

    @Schema(description = "Nuovo nome del paziente",type = "string",example = "Ferdinando")
    private String nuovoNome;

    @Schema(description = "Nuovo cognome del paziente",type = "string",example = "De Lorenzi")
    private String nuovoCognome;

    @Schema(description = "Nuova data di nascita del paziente",type = "string",example = "1985-07-05")
    private String nuovaDataNascita;

    @Schema(description = "Nuovo luogo di nascita del paziente",type = "string",example = "Galatina")
    private String nuovoLuogoNascita;

    @Schema(description = "Nuova provincia di nascita del paziente",type = "string",example = "Lecce")
    private String nuovaProvinciaNascita;

    @Schema(description = "Nuovo contatto di riferimento del paziente",type = "integer",example = "1")
    private Integer nuovoContattoRiferimentoId;

    @Schema(description = "Nuovo reparto nel quale viene curato il paziente",type = "integer",example = "1")
    private Integer nuovoRepartoId;
}
