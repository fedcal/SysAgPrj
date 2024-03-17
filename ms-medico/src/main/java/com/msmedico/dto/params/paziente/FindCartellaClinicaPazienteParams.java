package com.msmedico.dto.params.paziente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FindCartellaClinicaPazienteParams {
    @Schema(description = "Id cartella clinica",type = "integer")
    private Integer idCartellaClinica;
    @Schema(description = "Id paziente",type = "integer")
    private Integer idPaziente;
}
