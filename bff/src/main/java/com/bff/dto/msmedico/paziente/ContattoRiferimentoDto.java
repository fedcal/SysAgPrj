package com.bff.dto.msmedico.paziente;

import lombok.Data;

@Data
public class ContattoRiferimentoDto {
    private Integer idContatto;
    private String nome;
    private String cognome;
    private String numeroCellulare;
}
