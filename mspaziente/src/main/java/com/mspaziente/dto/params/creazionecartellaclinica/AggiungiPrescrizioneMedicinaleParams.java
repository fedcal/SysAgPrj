package com.mspaziente.dto.params.creazionecartellaclinica;

import lombok.Data;

@Data
public class AggiungiPrescrizioneMedicinaleParams {
    private Integer idMedico;
    private Integer idMedicinale;
    private Integer idCartellaClinica;
    private Integer idVisita;
}
