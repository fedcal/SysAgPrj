package com.msinfo.dto.params.reparto;

import com.msinfo.dto.MedicoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AddRepartoParams {
    @Schema(description = "Nome del reparto da aggiungere",type = "string",example = "Chirurgia")
    private String nomeReparto;

    @Schema(description = "Descrizione del reparto da aggiungere",type = "string",example = "Chirurgia estetica")
    private String descrizione;

    @Schema(description = "Ala del reparto da aggiungere",type = "string",example = "Piano 1, ala Est")
    private String alaReparto;

    @Schema(description = "Id relativo al capo reparto del reparto da aggiungere",type = "integer",example = "2")
    private Integer capoReparto;
}
