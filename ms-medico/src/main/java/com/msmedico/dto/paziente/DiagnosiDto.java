package com.msmedico.dto.paziente;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DiagnosiDto {
    private Integer idDiagnosi;

    @Column(name = "tipo_diagnosi")
    private String tipoDiagnosi;

    @Column(name = "descrizione")
    private String descrizione;
}
