package com.msinfo.dto;

import lombok.Data;

import java.util.Set;
@Data
public class RepartoDto {
    private Integer idReparto;
    private String nomeReparto;
    private String descrizione;
    private String alaReparto;
    private MedicoDto capoReparto;
}
