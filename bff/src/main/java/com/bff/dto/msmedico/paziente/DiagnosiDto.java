package com.bff.dto.msmedico.paziente;

import lombok.Data;

@Data
public class DiagnosiDto {
    private Integer idDiagnosi;
    private String tipoDiagnosi;
    private String descrizione;
}
