package com.mspaziente.dto.params.operazionigenerali;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ModificaPazienteParams {
    @Schema(description = "Id del paziente da modificare",type = "integer")
    private Integer idPaziente;

    @Schema(description = "Nuovo nome del paziente",type = "string")
    private String nuvoNome;
    @Schema(description = "Nuovo cognome del paziente",type = "integer")
    private String nuovoCognome;
    @Schema(description = "Nuova data di nascita del paziente",type = "integer")
    private String nuovaDataNascita;
    @Schema(description = "Nuovo luogo di nascita del paziente",type = "integer")
    private String nuovoLuogoNascita;
    @Schema(description = "Nuova provincia di nascita del paziente",type = "integer")
    private String nuovaProvinciaNascita;

    @Schema(description = "Id del nuovo contatto di riferimento",type = "integer")
    private Integer idContattoRiferimento;
    @Schema(description = "Id del nuovo reparto",type = "integer")
    private Integer idReparto;
    @Schema(description = "Id della nuova cartella clinica",type = "integer")
    private Integer idCartellaClinica;
}
