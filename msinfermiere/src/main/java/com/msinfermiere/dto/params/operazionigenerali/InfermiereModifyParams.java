package com.msinfermiere.dto.params.operazionigenerali;

import lombok.Data;

@Data
public class InfermiereModifyParams {
    private Integer idInfermiere;
    private String nomeRicerca;
    private String cognomeRicerca;

    private String nuovoNome;
    private String nuovoCognome;
    private String nuovoTurno;
}
