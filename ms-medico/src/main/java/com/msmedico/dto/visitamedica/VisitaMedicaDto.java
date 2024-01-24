package com.msmedico.dto.visitamedica;

import lombok.Data;

@Data
public class VisitaMedicaDto {
    private Integer idVisitaMedica;
    private String nome;
    private String tipologia;
    private String descrizione;
}
