package com.bff.dto.msinfermiere;

import com.bff.dto.msinfermiere.account.ProfiloDto;
import lombok.Data;

@Data
public class InfermiereDto {
    private Integer idInfermiere;
    private String nome;
    private String cognome;
    private String turno;
    private ProfiloDto profilo;
}
