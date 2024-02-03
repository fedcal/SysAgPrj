package com.msinfermiere.dto;

import com.msinfermiere.dto.account.ProfiloDto;
import com.msinfermiere.dto.relationentities.MedicinaleSottoministrazioneDto;

import java.util.Set;

public class InfermiereDto {
    private Integer idInfermiere;
    private String nome;
    private String cognome;
    private String turno;
    private ProfiloDto profilo;
    private Set<MedicinaleSottoministrazioneDto> medicinaleSottoministrazione;
}
