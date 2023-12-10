package com.msinfo.dto;


import com.msinfo.entity.account.Profilo;
import lombok.Data;

@Data
public class OperazioneConsentitaDto {
    private Integer idOperazioneConentita;
    private Profilo profilo;
    private OperazioneAccountDto operazioneAccount;
}
