package com.msinfermiere.dto.relationentities;

import com.msinfermiere.dto.MedicoDto;
import com.msinfermiere.dto.RepartoDto;
import lombok.Data;

@Data
public class RepartoMedicoDto {
    private Integer idRelazione;
    private MedicoDto medico;
    private RepartoDto reparto;
}
