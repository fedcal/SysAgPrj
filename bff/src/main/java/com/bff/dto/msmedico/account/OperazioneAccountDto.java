package com.bff.dto.msmedico.account;

import com.bff.dto.msmedico.relationentities.OperazioneConsentitaDto;
import lombok.Data;

import java.util.Set;
@Data
public class OperazioneAccountDto {
    private Integer idOperazione;
    private String nomeOperazione;
    private String descrizione;
    private Set<OperazioneConsentitaDto> operazioneConsentitaSet;
}
