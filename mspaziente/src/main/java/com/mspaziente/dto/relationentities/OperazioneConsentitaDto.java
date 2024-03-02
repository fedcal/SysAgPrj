package com.mspaziente.dto.relationentities;

import com.mspaziente.dto.account.OperazioneAccountDto;
import com.mspaziente.dto.account.ProfiloDto;
import lombok.Data;

@Data
public class OperazioneConsentitaDto {
    private Integer idOperazioneConentita;
    private ProfiloDto profilo;
    private OperazioneAccountDto operazioneAccount;
}
