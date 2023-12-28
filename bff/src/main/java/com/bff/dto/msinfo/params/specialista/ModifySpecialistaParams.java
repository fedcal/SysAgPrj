package com.bff.dto.msinfo.params.specialista;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ModifySpecialistaParams {
    @Schema(description = "Id dello specialista da modificare")
    private Integer idSpecialista;

    @Schema(description = "Nuovo nome dello specialista")
    private String nuovoNome;

    @Schema(description = "Nuovo cognome dello specialista")
    private String nuovoCognome;

    @Schema(description = "Nuova specializzazione dello specialista")
    private String nuovaSpecializzazione;

    @Schema(description = "Nuovo turno dello specialista")
    private String nuovoTurno;

    @Schema(description = "Nuovo profilo dello specialista")
    private Integer nuovoProfilo;
}
