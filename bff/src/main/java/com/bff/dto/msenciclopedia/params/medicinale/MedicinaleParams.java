package com.bff.dto.msenciclopedia.params.medicinale;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MedicinaleParams {
    @Schema(description = "Nome medicinale")
    private String nome;

    @Schema(description = "Descrizione medicinale")
    private String descrizione;

    @Schema(description = "Dosaggio medicinale")
    private String dosaggio;
}
