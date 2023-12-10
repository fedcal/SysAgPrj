package com.msinfo.dto;

import com.msinfo.entity.account.Profilo;
import lombok.Data;

@Data
public class SpecialistaDto {
    private Integer idSpecialista;
    private String nome;
    private String cognome;
    private String specializzazione;
    private String turno;
    private Profilo profilo;
}
