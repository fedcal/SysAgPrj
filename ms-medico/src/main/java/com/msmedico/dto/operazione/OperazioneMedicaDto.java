package com.msmedico.dto.operazione;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class OperazioneMedicaDto {
    private Integer idOperazioneMedica;
    private String nome;
    private String descrizione;
    private String tipologia;
}
