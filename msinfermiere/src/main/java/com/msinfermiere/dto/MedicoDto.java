package com.msinfermiere.dto;

import com.msinfermiere.dto.account.ProfiloDto;
import com.msinfermiere.dto.relationentities.RepartoMedicoDto;
import lombok.Data;

import java.util.Set;
@Data
public class MedicoDto {
    private Integer idMedico;
    private String nome;
    private String cognome;
    private String turno;
    private ProfiloDto profilo;
    private Set<RepartoMedicoDto> repartoMedicoSet;
}
