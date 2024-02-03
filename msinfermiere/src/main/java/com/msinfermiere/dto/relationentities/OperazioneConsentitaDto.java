package com.msinfermiere.dto.relationentities;

import com.msinfermiere.dto.account.OperazioneAccountDto;
import com.msinfermiere.dto.account.ProfiloDto;
import lombok.Data;

@Data
public class OperazioneConsentitaDto {
    private Integer idOperazioneConentita;
    private ProfiloDto profilo;
    private OperazioneAccountDto operazioneAccount;
}
