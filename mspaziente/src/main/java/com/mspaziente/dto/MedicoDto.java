package com.mspaziente.dto;

import com.mspaziente.dto.account.ProfiloDto;
import com.mspaziente.dto.relationentities.RepartoMedicoDto;
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
