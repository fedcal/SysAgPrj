package com.mspaziente.dto.params.creazionecartellaclinica;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AggiungiPrescrizioneMedicinaleParams {
    @Schema(description = "Id medico",type = "integer")
    private Integer idMedico;
    @Schema(description = "Id medicinale",type = "integer")
    private Integer idMedicinale;
    @Schema(description = "Id cartella clinica",type = "integer")
    private Integer idCartellaClinica;
    @Schema(description = "Id visita",type = "integer")
    private Integer idVisita;
}
