package com.bff.dto.msinfo.params.reparto;

import com.bff.dto.msinfo.MedicoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ModificaRepartoParams {
    @Schema(description = "Id del reparto che bisogna modificare")
    private Integer idRepartoRicerca;

    @Schema(description = "Nome del reparto che bisogna modificare")
    private String nomeRepartoRicerca;

    @Schema(description = "Nome del nuovo reparto")
    private String nomeRepartoNuovo;

    @Schema(description = "Nuova descrizione del reparto")
    private String descrizioneNuovo;

    @Schema(description = "La nuova ala del reparto")
    private String alaRepartoNuovo;

    @Schema(description = "Capo del nuovo reparto")
    private MedicoDto capoRepartoNuovo;
}
