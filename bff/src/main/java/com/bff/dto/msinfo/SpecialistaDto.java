package com.bff.dto.msinfo;

import lombok.Data;

@Data
public class SpecialistaDto {
    private Integer idSpecialista;
    private String nome;
    private String cognome;
    private String specializzazione;
    private String turno;
    private ProfiloDto profilo;
}
