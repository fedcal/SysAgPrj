package com.msinfo.dto.params.reparto;

import com.msinfo.dto.MedicoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddRepartoParams {
    @Schema(description = "Nome del reparto da aggiungere",type = "string")
    private String nomeReparto;

    @Schema(description = "Descrizione del reparto da aggiungere",type = "string")
    private String descrizione;

    @Schema(description = "Ala del reparto da aggiungere",type = "string")
    private String alaReparto;

    @Schema(description = "Id relativo al capo reparto del reparto da aggiungere",type = "integer")
    private Integer capoReparto;
}
