package com.mspaziente.dto.params.creazionecartellaclinica;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AggiungiMedicinaleSottoministrazioneParams {
    @Schema(description = "Id infermiere",type = "integer")
    private Integer idInfermiere;
    @Schema(description = "Id medicinale",type = "integer")
    private Integer idMedicinale;
    @Schema(description = "Id cartella clinica",type = "integer")
    private Integer idCartellaClinica;
}
