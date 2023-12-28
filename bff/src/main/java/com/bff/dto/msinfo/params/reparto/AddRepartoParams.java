package com.bff.dto.msinfo.params.reparto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddRepartoParams {
    @Schema(description = "Nome del reparto da aggiungere")
    private String nomeReparto;

    @Schema(description = "Descrizione del reparto da aggiungere")
    private String descrizione;

    @Schema(description = "Ala del reparto da aggiungere")
    private String alaReparto;

    @Schema(description = "Id relativo al capo reparto del reparto da aggiungere")
    private Integer capoReparto;
}
