package com.msinfo.dto.params.specialista;

import com.msinfo.dto.ProfiloDto;
import lombok.Data;

@Data
public class AddSpecialistaParams {
    private String nome;
    private String cognome;
    private String specializzazione;
    private String turno;
    private Integer profilo;
}
