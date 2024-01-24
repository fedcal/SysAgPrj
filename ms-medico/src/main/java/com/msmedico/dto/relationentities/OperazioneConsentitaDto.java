package com.msmedico.dto.relationentities;

import com.msmedico.dto.account.OperazioneAccountDto;
import com.msmedico.dto.account.ProfiloDto;
import lombok.Data;

@Data
public class OperazioneConsentitaDto {
    private Integer idOperazioneConentita;
    private ProfiloDto profilo;
    private OperazioneAccountDto operazioneAccount;
}
