package com.msinfermiere.dto.visitamedica;

import com.msinfermiere.dto.relationentities.VisitaEffettuataMedicoDto;
import com.msinfermiere.dto.relationentities.VisitaPrescrizioneDto;
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
