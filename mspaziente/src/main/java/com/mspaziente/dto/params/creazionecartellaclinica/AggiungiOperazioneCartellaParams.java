package com.mspaziente.dto.params.creazionecartellaclinica;

import lombok.Data;

@Data
public class AggiungiOperazioneCartellaParams {
    private Integer idOperazioneMedica;
    private Integer idCartellaClinica;
    private Integer idMedico;
    private Integer idReferoOperazione;
}
