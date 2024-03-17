package com.msmedico.dto.params.prescrizione.medicinale;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PrescrizioneMedicinaleAddParams {
    @Schema(description = "Id del medico",type = "integer")
    private Integer idMedico;

    @Schema(description = "Id del medicinale",type = "integer")
    private Integer idMedicinale;

    @Schema(description = "Id della cartella clinica",type = "integer")
    private Integer idCartellaClinica;
}
