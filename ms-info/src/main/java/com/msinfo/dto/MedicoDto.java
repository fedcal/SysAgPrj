package com.msinfo.dto;

import com.msinfo.entity.account.Profilo;
import com.msinfo.entity.relantionentities.RepartoMedico;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Data
public class MedicoDto {
    private Integer idMedico;
    private String nome;
    private String cognome;
    private String turno;
    private Profilo profilo;
    private Set<RepartoMedico> repartoMedicoSet;

}
