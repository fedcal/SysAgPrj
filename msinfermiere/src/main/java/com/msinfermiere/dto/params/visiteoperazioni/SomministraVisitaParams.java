package com.msinfermiere.dto.params.visiteoperazioni;

import lombok.Data;

@Data
public class SomministraVisitaParams {
    private Integer idInfermiere;
    private Integer idVisita;
    private Integer idCartellaClinica;
}
