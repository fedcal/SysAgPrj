package com.msmedico.dto.params.prescrizione.operazione;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PrescrizioneOperazioneModifyParams {
    @Schema(description = "Id del paziente",type = "integer")
    private Integer idRelazione;

    @Schema(description = "Id nuova operazione medica",type = "integer")
    private Integer nuovaOperazioneMedica;
    @Schema(description = "Id nuova cartella clinica",type = "integer")
    private Integer nuovaCartellaClinica;
    @Schema(description = "Id nuovo medico",type = "integer")
    private Integer nuovoMedico;
}
