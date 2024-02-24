package com.bff.dto.msinfermiere.visitamedica;

import lombok.Data;

@Data
public class RefertoVisitaMedicaDto {
    private Integer idReferto;
    private String tipologia;
    private String descrizione;
    private String dataReferto;
}
