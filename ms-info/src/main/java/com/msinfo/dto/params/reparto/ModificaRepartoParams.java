package com.msinfo.dto.params.reparto;

import com.msinfo.dto.MedicoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ModificaRepartoParams {
    @Schema(description = "Id del reparto che bisogna modificare",type = "integer",example = "1")
    private Integer idRepartoRicerca;

    @Schema(description = "Nome del reparto che bisogna modificare",type = "string",example = "Chirurgia")
    private String nomeRepartoRicerca;

    @Schema(description = "Nome del nuovo reparto",type = "string",example = "Chirurgia2")
    private String nomeRepartoNuovo;

    @Schema(description = "Nuova descrizione del reparto",type = "string",example = "Chirurgia estetica 2")
    private String descrizioneNuovo;

    @Schema(description = "La nuova ala del reparto",type = "string",example = "Piano terra, ala Est")
    private String alaRepartoNuovo;

    @Schema(description = "Capo del nuovo reparto",type = "integer",example = "1")
    private Integer capoRepartoNuovo;
}
