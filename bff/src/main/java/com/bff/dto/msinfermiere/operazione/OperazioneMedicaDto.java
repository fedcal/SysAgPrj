package com.bff.dto.msinfermiere.operazione;

import com.bff.dto.msinfermiere.relationentities.OperazioneCartellaDto;
import com.bff.dto.msinfermiere.relationentities.OperazionePrescrizioneDto;
import lombok.Data;

import java.util.Set;
@Data
public class OperazioneMedicaDto {
    private Integer idOperazioneMedica;
    private String nome;
    private String descrizione;
    private String tipologia;
    private Set<OperazioneCartellaDto> operazioneCartella;
    private Set<OperazionePrescrizioneDto> operazionePrescrizione;
}
