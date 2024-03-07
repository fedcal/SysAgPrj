package com.mspaziente.dto;

import com.mspaziente.dto.account.ProfiloDto;
import com.mspaziente.dto.relationentities.MedicinaleSottoministrazioneDto;
import com.mspaziente.dto.relationentities.VisitaSottoministrazioneInfermiereDto;
import lombok.Data;

import java.util.Set;
@Data
public class InfermiereDto {
    private Integer idInfermiere;
    private String nome;
    private String cognome;
    private String turno;
    private ProfiloDto profilo;
}
