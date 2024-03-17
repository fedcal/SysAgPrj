package com.msmedico.dto.params.prescrizione.medicinale;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PrescrizioneMedicinaleModifyParams {
    @Schema(description = "Id della relazione",type = "integer")
    private Integer idRelazione;

    @Schema(description = "Id del nuovo medicinale",type = "integer")
    private Integer nuovoMedicinale;

    @Schema(description = "Id della nuova cartella clinica",type = "integer")
    private Integer nuovaCartellaClinica;

    @Schema(description = "Id del nuovo medico",type = "integer")
    private Integer nuovoMedico;
}
