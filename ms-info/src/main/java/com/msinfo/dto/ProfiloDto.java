package com.msinfo.dto;

import com.msinfo.entity.infermieri.Infermiere;
import com.msinfo.entity.medici.Medico;
import com.msinfo.entity.pazienti.Paziente;
import com.msinfo.entity.relantionentities.OperazioneConsentita;
import com.msinfo.entity.specialista.Specialista;
import lombok.Data;

import java.util.Set;

@Data
public class ProfiloDto {
    private Integer idProfilo;
    private String tipo;
    private String descrizione;
}
