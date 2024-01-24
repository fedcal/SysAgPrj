package com.msmedico.dto.params.visualizzastato;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FindOperazioneParams {
    @Schema(description = "Id della relazione da ricercare",type = "integer")
    private Integer idRelazione;

    @Schema(description = "Id dell'operazione",type = "integer")
    private Integer idOperazione;

    @Schema(description = "Nome dell'operazione",type = "string")
    private String nomeOperazione;

    @Schema(description = "Id della cartella clinica",type = "integer")
    private Integer idCartellaClinica;

    @Schema(description = "Id del paziente",type = "integer")
    private Integer idPaziente;

    @Schema(description = "Nome del paziennte",type = "string")
    private String nomePaziente;

    @Schema(description = "Cognome del paziente",type = "string")
    private String cognomePaziente;

    @Schema(description = "Id del medico",type = "integer")
    private Integer idMedico;

    @Schema(description = "Nome del medico",type = "string")
    private String nomeMedico;

    @Schema(description = "Cognome del medico",type = "string")
    private String cognomeMedico;

    @Schema(description = "Id del referto",type = "integer")
    private Integer idReferto;
}
