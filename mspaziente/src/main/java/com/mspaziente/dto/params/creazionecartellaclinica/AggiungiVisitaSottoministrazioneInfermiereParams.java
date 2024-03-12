package com.mspaziente.dto.params.creazionecartellaclinica;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AggiungiVisitaSottoministrazioneInfermiereParams {
    @Schema(description = "Id innfermiere",type = "integer")
    private Integer idInfermiere;
    @Schema(description = "Id visita",type = "integer")
    private Integer idVisita;
    @Schema(description = "Id cartella clinica",type = "integer")
    private Integer idCartellaClinica;
}
