package com.msinfo.dto;

import com.msinfo.entity.relantionentities.OperazioneConsentita;
import lombok.Data;

import java.util.Set;

@Data
public class OperazioneAccountDto {
    private Integer idOperazione;
    private String nomeOperazione;
    private String descrizione;
    private Set<OperazioneConsentita> operazioneConsentitaSet;
}
