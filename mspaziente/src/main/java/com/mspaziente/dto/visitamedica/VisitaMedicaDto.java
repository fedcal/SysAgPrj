package com.mspaziente.dto.visitamedica;

import com.mspaziente.dto.relationentities.VisitaPrescrizioneDto;
import com.mspaziente.dto.relationentities.VisitaSottoministrazioneInfermiereDto;
import com.mspaziente.dto.relationentities.VisitaSottoministrazioneMedicoDto;
import lombok.Data;

import java.util.Set;

@Data
public class VisitaMedicaDto {
    private Integer idVisitaMedica;
    private String nome;
    private String tipologia;
    private String descrizione;
}
