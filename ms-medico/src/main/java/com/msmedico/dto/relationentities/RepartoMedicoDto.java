package com.msmedico.dto.relationentities;

import com.msmedico.dto.MedicoDto;
import com.msmedico.dto.RepartoDto;
import com.msmedico.entity.Medico;
import com.msmedico.entity.Reparto;
import lombok.Data;

@Data
public class RepartoMedicoDto {
    private Integer idRelazione;
    private MedicoDto medico;
    private RepartoDto reparto;
}
