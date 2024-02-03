package com.bff.dto.msmedico.relationentities;

import com.bff.dto.msmedico.account.OperazioneAccountDto;
import com.bff.dto.msmedico.account.ProfiloDto;
import lombok.Data;

@Data
public class OperazioneConsentitaDto {
    private Integer idOperazioneConentita;
    private ProfiloDto profilo;
    private OperazioneAccountDto operazioneAccount;
}
