package com.bff.dto.msmedico.operazione;

import lombok.Data;

@Data
public class OperazioneMedicaDto {
    private Integer idOperazioneMedica;
    private String nome;
    private String descrizione;
    private String tipologia;
}
