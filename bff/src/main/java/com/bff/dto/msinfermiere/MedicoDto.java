package com.bff.dto.msinfermiere;

import com.bff.dto.msinfermiere.account.ProfiloDto;
import com.bff.dto.msinfermiere.relationentities.RepartoMedicoDto;
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
