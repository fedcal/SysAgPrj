package com.msinfermiere.dto.account;

import com.msinfermiere.dto.relationentities.OperazioneConsentitaDto;
import lombok.Data;

import java.util.Set;
@Data
public class OperazioneAccountDto {
    private Integer idOperazione;
    private String nomeOperazione;
    private String descrizione;
    private Set<OperazioneConsentitaDto> operazioneConsentitaSet;
}
