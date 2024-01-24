package com.msmedico.dto;

import com.msmedico.dto.account.ProfiloDto;
import lombok.Data;

@Data
public class MedicoDto {
    private Integer idMedico;
    private String nome;
    private String cognome;
    private String turno;
    private ProfiloDto profilo;
}
