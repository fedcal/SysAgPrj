package com.msinfermiere.dto.account;

import com.msinfermiere.dto.InfermiereDto;
import com.msinfermiere.dto.relationentities.OperazioneConsentitaDto;
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
