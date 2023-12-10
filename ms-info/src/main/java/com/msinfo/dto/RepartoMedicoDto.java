package com.msinfo.dto;

import com.msinfo.entity.medici.Medico;
import com.msinfo.entity.reparto.Reparto;
import lombok.Data;

@Data
public class RepartoMedicoDto {
    private Integer idRelazione;
    private Medico medico;
    private Reparto reparto;
}
