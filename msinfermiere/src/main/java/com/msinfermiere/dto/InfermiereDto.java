package com.msinfermiere.dto;

import com.msinfermiere.dto.account.ProfiloDto;
import com.msinfermiere.dto.relationentities.MedicinaleSottoministrazioneDto;
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
