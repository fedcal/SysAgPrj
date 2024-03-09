package com.mspaziente.dto.params.operazionigenerali;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddPazienteParams {
    @Schema(description = "Id contatto di riferimento",type = "integer")
    private Integer idContattoRiferimento;
    @Schema(description = "Id reparto",type = "integer")
    private Integer idReparto;
    @Schema(description = "Id cartella clinica",type = "integer")
    private Integer idCartellaClinica;

    @Schema(description = "Nome del paziente",type = "string")
    private String nome;
    @Schema(description = "Cognome del paziente",type = "string")
    private String cognome;
    @Schema(description = "Data di nascita del paziente",type = "string")
    private String dataNascita;
    @Schema(description = "Luogo di nascita",type = "string")
    private String luogoNascita;
    @Schema(description = "Provincia di nascita",type = "string")
    private String provinciaNascita;
}
