package com.msinfo.dto.params.medico;

import com.msinfo.dto.ProfiloDto;
import lombok.Data;

@Data
public class AddMedicoParams {
    private String nome;
    private String cognome;
    private String turno;
    private Integer profilo;
}
