package com.bff.dto.msinfermiere.relationentities;

import com.bff.dto.msinfermiere.MedicoDto;
import com.bff.dto.msinfermiere.RepartoDto;
import lombok.Data;

@Data
public class RepartoMedicoDto {
    private Integer idRelazione;
    private MedicoDto medico;
    private RepartoDto reparto;
}
