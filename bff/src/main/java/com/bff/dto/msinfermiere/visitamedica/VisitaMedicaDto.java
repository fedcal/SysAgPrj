package com.bff.dto.msinfermiere.visitamedica;

import com.bff.dto.msinfermiere.relationentities.VisitaPrescrizioneDto;
import com.bff.dto.msinfermiere.relationentities.VisitaEffettuataMedicoDto;
import lombok.Data;

import java.util.Set;
@Data
public class VisitaMedicaDto {
    private Integer idVisitaMedica;
    private String nome;
    private String tipologia;
    private String descrizione;
    private Set<VisitaPrescrizioneDto> visitaPrescrizione;
    private Set<VisitaEffettuataMedicoDto> visitaSottoministrazioneMedico;
}
