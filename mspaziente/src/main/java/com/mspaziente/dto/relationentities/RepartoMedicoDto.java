package com.mspaziente.dto.relationentities;

import com.mspaziente.dto.MedicoDto;
import com.mspaziente.dto.RepartoDto;
import lombok.Data;

@Data
public class RepartoMedicoDto {
    private Integer idRelazione;
    private MedicoDto medico;
    private RepartoDto reparto;
}
