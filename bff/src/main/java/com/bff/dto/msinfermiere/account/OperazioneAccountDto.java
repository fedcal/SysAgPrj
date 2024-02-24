package com.bff.dto.msinfermiere.account;

import com.bff.dto.msinfermiere.relationentities.OperazioneConsentitaDto;
import lombok.Data;

import java.util.Set;
@Data
public class OperazioneAccountDto {
    private Integer idOperazione;
    private String nomeOperazione;
    private String descrizione;
    private Set<OperazioneConsentitaDto> operazioneConsentitaSet;
}
