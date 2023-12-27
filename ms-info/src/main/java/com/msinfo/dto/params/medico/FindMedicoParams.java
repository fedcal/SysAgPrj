package com.msinfo.dto.params.medico;

import lombok.Data;

@Data
public class FindMedicoParams {
    private Integer idMedico;
    private String nome;
    private String cognome;
}
