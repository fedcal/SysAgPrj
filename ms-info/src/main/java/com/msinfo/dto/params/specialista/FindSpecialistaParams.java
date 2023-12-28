package com.msinfo.dto.params.specialista;

import com.msinfo.dto.ProfiloDto;
import lombok.Data;

@Data
public class FindSpecialistaParams {
    private Integer idSpecialista;
    private String nome;
    private String cognome;
}
