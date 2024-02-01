package com.bff.dto.msmedico.params.prescrizione.operazione;

import lombok.Data;

@Data
public class PrescrizioneOperazioneModifyParams {
    private Integer idRelazione;

    private Integer nuovaOperazioneMedica;
    private Integer nuovaCartellaClinica;
    private Integer nuovoMedico;
}
