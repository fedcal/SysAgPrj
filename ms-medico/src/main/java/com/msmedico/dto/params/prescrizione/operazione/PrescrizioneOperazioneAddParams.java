package com.msmedico.dto.params.prescrizione.operazione;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PrescrizioneOperazioneAddParams {
    @Schema(description = "Id dell'operazione medica",type = "integer")
    private Integer operazioneMedica;
    @Schema(description = "Id della cartella clinica",type = "integer")
    private Integer cartellaClinica;
    @Schema(description = "Id del medico",type = "integer")
    private Integer medico;
}
