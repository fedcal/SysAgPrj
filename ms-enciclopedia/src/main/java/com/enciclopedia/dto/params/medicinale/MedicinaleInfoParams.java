package com.enciclopedia.dto.params.medicinale;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MedicinaleInfoParams {
    @Schema(description = "Id medicinale")
    private Integer idMedicinale;

    @Schema(description = "Nome medicinale")
    private String nomeMedicinale;
}
