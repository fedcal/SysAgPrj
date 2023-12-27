package com.msinfo.dto.params.medico;

import com.msinfo.dto.ProfiloDto;
import lombok.Data;

@Data
public class ModifyMedicoParams {
    private Integer idMedico;

    private String nuovoNome;
    private String nuovoCognome;
    private String nuovoTurno;
    private Integer nuovoProfilo;
}
