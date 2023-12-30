package com.msinfo.dto.params.specialista;

import com.msinfo.dto.ProfiloDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ModifySpecialistaParams {
    @Schema(description = "Id dello specialista da modificare",type = "integer",example = "1")
    private Integer idSpecialista;

    @Schema(description = "Nuovo nome dello specialista",type = "string",example = "Mario")
    private String nuovoNome;

    @Schema(description = "Nuovo cognome dello specialista",type = "string",example = "Rossi")
    private String nuovoCognome;

    @Schema(description = "Nuova specializzazione dello specialista",type = "string",example = "Laringoiatra")
    private String nuovaSpecializzazione;

    @Schema(description = "Nuovo turno dello specialista",type = "string",example = "Mer. 8:00-18:00")
    private String nuovoTurno;

    @Schema(description = "Nuovo profilo dello specialista",type = "integer",example = "1")
    private Integer nuovoProfilo;
}
