package com.mspaziente.dto.params.creazionecartellaclinica;

import lombok.Data;

@Data
public class AggiuntaDiagnosiParams {
    private Integer idCartellaClinica;

    private String tipoDiagnosi;
    private String descrizione;
}
