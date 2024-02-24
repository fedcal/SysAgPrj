package com.msinfermiere.dto.params.visiteoperazioni;

import lombok.Data;

@Data
public class FiltraVisiteSottoministrateInfermieriParams {
    private Integer idSottoministrazione;
    private Integer idInfermiere;
    private Integer idVisita;
    private Integer idCartellaClinica;

    private String nomeInfermiere;
    private String cognomeInfermiere;
    private String nomeVisita;
    private String nomePaziente;
    private String cognomePaziente;
}
