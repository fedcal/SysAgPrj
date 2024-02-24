package com.bff.dto.msinfermiere.account;

import com.bff.dto.msinfermiere.InfermiereDto;
import com.bff.dto.msinfermiere.relationentities.OperazioneConsentitaDto;
import lombok.Data;

import java.util.Set;
@Data
public class ProfiloDto {
    private Integer idProfilo;
    private String tipo;
    private String descrizione;
    private Set<OperazioneConsentitaDto> operazioneConsentitaSet;
    private Set<InfermiereDto> infermieri;
}
