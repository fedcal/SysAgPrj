package com.mspaziente.dto.params.creazionecartellaclinica;

import lombok.Data;

@Data
public class AggiungiVisitaMedicaCartellaParams {
    private Integer idVisitaMedica;
    private Integer idCartellaClinica;
    private Integer idReferto;
}
