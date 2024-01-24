package com.msmedico.dto.relationentities;

import com.msmedico.entity.Medico;
import com.msmedico.entity.Reparto;
import lombok.Data;

@Data
public class RepartoMedicoDto {
    private Integer idRelazione;
    private Medico medico;
    private Reparto reparto;
}
