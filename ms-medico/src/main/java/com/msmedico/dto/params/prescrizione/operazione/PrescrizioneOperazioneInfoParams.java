package com.msmedico.dto.params.prescrizione.operazione;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PrescrizioneOperazioneInfoParams {
    @Schema(description = "Id del medico",type = "integer")
    private Integer idMedico;
    @Schema(description = "Id della cartella clinica",type = "integer")
    private Integer idCartella;
    @Schema(description = "Id dell'operazione",type = "integer")
    private Integer idOperazione;
    @Schema(description = "Id del paziente",type = "integer")
    private Integer idPaziente;

    @Schema(description = "Nome operazione",type = "string")
    private String nomeOperazione;
    @Schema(description = "Nome medico",type = "string")
    private String nomeMedico;
    @Schema(description = "Cognome medico",type = "string")
    private String cognomeMedico;
    @Schema(description = "Nome paziente",type = "string")
    private String nomePaziente;
    @Schema(description = "Cognome paziente",type = "string")
    private String cognomePaziente;
}
