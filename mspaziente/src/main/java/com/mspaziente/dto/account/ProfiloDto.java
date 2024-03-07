package com.mspaziente.dto.account;

import com.mspaziente.dto.InfermiereDto;
import com.mspaziente.dto.MedicoDto;
import com.mspaziente.dto.PazienteDto;
import com.mspaziente.dto.relationentities.OperazioneConsentitaDto;
import lombok.Data;

import java.util.Set;

@Data
public class ProfiloDto {
    private Integer idProfilo;
    private String tipo;
    private String descrizione;
}
