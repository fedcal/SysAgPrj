package com.mspaziente.dto.operazione;

import com.mspaziente.dto.relationentities.OperazioneCartellaDto;
import com.mspaziente.dto.relationentities.OperazionePrescrizioneDto;
import lombok.Data;

import java.util.Set;
@Data
public class OperazioneMedicaDto {
    private Integer idOperazioneMedica;
    private String nome;
    private String descrizione;
    private String tipologia;
}
