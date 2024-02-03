package com.bff.dto.msmedico.relationentities;


import com.bff.dto.msmedico.MedicoDto;
import com.bff.dto.msmedico.RepartoDto;
import lombok.Data;

@Data
public class RepartoMedicoDto {
    private Integer idRelazione;
    private MedicoDto medico;
    private RepartoDto reparto;
}
