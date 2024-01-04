package com.msmedico.dto.params.visualizzastato;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FindStatoVisitaMedicaParams {
    @Schema(description = "Id della relazione relativa alla tabella VisitaMedicaCartella da ricercare",type = "integer")
    private Integer idRelazione;

    @Schema(description = "Id della cartella clinica relativa alla tabella VisitaMedicaCartella da ricercare",type = "integer")
    private Integer idCartella;

    @Schema(description = "Id della visita medica relativa alla tabella VisitaMedicaCartella da ricercare",type = "integer")
    private Integer idVisitaMedica;

    @Schema(description = "Id del referto relativo alla tabella VisitaMedicaCartella da ricercare",type = "integer")
    private Integer idReferto;
}
