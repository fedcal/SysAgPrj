package com.msinfo.dto;

import com.msinfo.entity.medici.Medico;
import com.msinfo.entity.relantionentities.RepartoMedico;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Data
public class RepartoDto {
    private Integer idReparto;
    private String nomeReparto;
    private String descrizione;
    private String alaReparto;
    private Medico capoReparto;
    private Set<RepartoMedico> repartoMedicoSet;
}
