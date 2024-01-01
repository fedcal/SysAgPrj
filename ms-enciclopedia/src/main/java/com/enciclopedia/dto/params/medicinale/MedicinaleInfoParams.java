package com.enciclopedia.dto.params.medicinale;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MedicinaleInfoParams {
    @Schema(description = "Id medicinale",type = "integer")
    private Integer idMedicinale;

    @Schema(description = "Nome medicinale",type = "string")
    private String nomeMedicinale;
}
