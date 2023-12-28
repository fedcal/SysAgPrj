package com.bff.dto.msinfo;

import java.util.Set;

public class OperazioneAccountDto {
    private Integer idOperazione;
    private String nomeOperazione;
    private String descrizione;
    private Set<OperazioneConsentitaDto> operazioneConsentitaSet;
}
