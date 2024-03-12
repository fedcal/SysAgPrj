package com.mspaziente.dto.params.creazionecartellaclinica;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AggiuntaOperazionePrescrizioneParams {
    @Schema(description = "Id operazione",type = "integer")
    private Integer idOperazione;
    @Schema(description = "Id cartella clinica",type = "integer")
    private Integer idCartella;
    @Schema(description = "Id medico",type = "integer")
    private Integer idMedico;
}
