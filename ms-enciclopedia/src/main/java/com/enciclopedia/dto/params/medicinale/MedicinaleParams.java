package com.enciclopedia.dto.params.medicinale;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MedicinaleParams {
    @Schema(description = "Nome medicinale",type = "string")
    private String nome;

    @Schema(description = "Descrizione medicinale",type = "string")
    private String descrizione;

    @Schema(description = "Dosaggio medicinale",type = "string")
    private String dosaggio;
}
