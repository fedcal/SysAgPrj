package com.msinfo.dto.params.specialista;

import com.msinfo.dto.ProfiloDto;
import lombok.Data;

@Data
public class ModifySpecialistaParams {
    private Integer idSpecialista;
    private String nuovoNome;
    private String nuovoCognome;
    private String nuovaSpecializzazione;
    private String nuovoTurno;
    private Integer nuovoProfilo;
}
