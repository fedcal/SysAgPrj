package com.msmedico.dto.params.prescrizione.operazione;

import lombok.Data;

@Data
public class PrescrizioneOperazioneInfoParams {
    private Integer idMedico;
    private Integer idCartella;
    private Integer idOperazione;
    private Integer idPaziente;

    private String nomeOperazione;
    private String nomeMedico;
    private String cognomeMedico;
    private String nomePaziente;
    private String cognomePaziente;
}
