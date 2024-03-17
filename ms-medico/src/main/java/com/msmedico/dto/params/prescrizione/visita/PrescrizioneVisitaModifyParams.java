package com.msmedico.dto.params.prescrizione.visita;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PrescrizioneVisitaModifyParams {
    @Schema(description = "Id relazione",type = "integer")
    private Integer idRelazione;

    @Schema(description = "Id nuova visita medica",type = "integer")
    private Integer nuovaVisitaMedica;
    @Schema(description = "Id nuova cartella clinica",type = "integer")
    private Integer nuovaCartellaClinica;
    @Schema(description = "Id nuovo medico",type = "integer")
    private Integer nuovoMedico;
}
