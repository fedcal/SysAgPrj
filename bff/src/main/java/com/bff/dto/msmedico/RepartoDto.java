package com.bff.dto.msmedico;

import lombok.Data;

@Data
public class RepartoDto {
    private Integer idReparto;
    private String nomeReparto;
    private String descrizione;
    private String alaReparto;
    private MedicoDto capoReparto;
}
