package com.mspaziente.dto.account;

import com.mspaziente.dto.relationentities.OperazioneConsentitaDto;
import lombok.Data;

import java.util.Set;

@Data
public class OperazioneAccountDto {
    private Integer idOperazione;
    private String nomeOperazione;
    private String descrizione;
}
