package com.msinfo.dto;

import lombok.Data;

@Data
public class InfermiereDto {
    private Integer idInfermiere;
    private String nome;
    private String cognome;
    private String turno;
    private ProfiloDto profilo;
}
