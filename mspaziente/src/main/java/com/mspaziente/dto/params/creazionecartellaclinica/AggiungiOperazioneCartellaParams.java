package com.mspaziente.dto.params.creazionecartellaclinica;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AggiungiOperazioneCartellaParams {
    @Schema(description = "Id operazione medica",type = "integer")
    private Integer idOperazioneMedica;
    @Schema(description = "Id cartella clinica",type = "integer")
    private Integer idCartellaClinica;
    @Schema(description = "Id medico",type = "integer")
    private Integer idMedico;
    @Schema(description = "Id referto operazione",type = "integer")
    private Integer idReferoOperazione;
}
