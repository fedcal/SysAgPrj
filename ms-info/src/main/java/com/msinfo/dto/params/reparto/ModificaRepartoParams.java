package com.msinfo.dto.params.reparto;

import com.msinfo.dto.MedicoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ModificaRepartoParams {
    @Schema(description = "Id del reparto che bisogna modificare",type = "integer")
    private Integer idRepartoRicerca;

    @Schema(description = "Nome del reparto che bisogna modificare",type = "string")
    private String nomeRepartoRicerca;

    @Schema(description = "Nome del nuovo reparto",type = "string")
    private String nomeRepartoNuovo;

    @Schema(description = "Nuova descrizione del reparto",type = "string")
    private String descrizioneNuovo;

    @Schema(description = "La nuova ala del reparto",type = "string")
    private String alaRepartoNuovo;

    @Schema(description = "Capo del nuovo reparto",type = "integer")
    private Integer capoRepartoNuovo;
}
