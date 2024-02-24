package com.bff.dto.msinfermiere.relationentities;

import com.bff.dto.msinfermiere.account.OperazioneAccountDto;
import com.bff.dto.msinfermiere.account.ProfiloDto;
import lombok.Data;

@Data
public class OperazioneConsentitaDto {
    private Integer idOperazioneConentita;
    private ProfiloDto profilo;
    private OperazioneAccountDto operazioneAccount;
}
