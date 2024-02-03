package com.msinfermiere.dto.visitamedica;

import com.msinfermiere.dto.relationentities.VisitaPrescrizioneDto;
import com.msinfermiere.dto.relationentities.VisitaSottoministrazioneMedicoDto;
import lombok.Data;

import java.util.Set;
@Data
public class VisitaMedicaDto {
    private Integer idVisitaMedica;
    private String nome;
    private String tipologia;
    private String descrizione;
    private Set<VisitaPrescrizioneDto> visitaPrescrizione;
    private Set<VisitaSottoministrazioneMedicoDto> visitaSottoministrazioneMedico;
}
