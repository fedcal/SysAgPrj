package com.bff.dto.msinfermiere.params.medicinalioperazioni;

import io.swagger.v3.oas.annotations.media.Schema;

public class SomministraMedicinaleParams {
    @Schema(description = "Id infermiere",type = "int")
    private Integer infermiere;
    @Schema(description = "Id medicinale",type = "int")
    private Integer medicinale;
    @Schema(description = "Id cartella clinica",type = "int")
    private Integer cartellaClinica;
}
