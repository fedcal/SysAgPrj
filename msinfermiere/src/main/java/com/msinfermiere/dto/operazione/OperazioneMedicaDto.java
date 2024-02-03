package com.msinfermiere.dto.operazione;

import com.msinfermiere.dto.relationentities.OperazioneCartellaDto;
import com.msinfermiere.dto.relationentities.OperazionePrescrizioneDto;
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
