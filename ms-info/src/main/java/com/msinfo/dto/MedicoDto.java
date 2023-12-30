package com.msinfo.dto;

import lombok.Data;

import java.util.Set;
@Data
public class MedicoDto {
    private Integer idMedico;
    private String nome;
    private String cognome;
    private String turno;
    private ProfiloDto profilo;
}
