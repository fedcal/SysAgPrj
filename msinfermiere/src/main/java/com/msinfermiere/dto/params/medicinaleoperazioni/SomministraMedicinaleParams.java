package com.msinfermiere.dto.params.medicinaleoperazioni;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SomministraMedicinaleParams {
    @Schema(description = "Id infermiere",type = "integer")
    private Integer infermiere;
    @Schema(description = "Id medicinale",type = "integer")
    private Integer medicinale;
    @Schema(description = "Id cartella clinica",type = "integer")
    private Integer cartellaClinica;
}
