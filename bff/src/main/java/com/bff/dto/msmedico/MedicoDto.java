package com.bff.dto.msmedico;

import com.bff.dto.msmedico.account.ProfiloDto;
import lombok.Data;

@Data
public class MedicoDto {
    private Integer idMedico;
    private String nome;
    private String cognome;
    private String turno;
    private ProfiloDto profilo;
}
