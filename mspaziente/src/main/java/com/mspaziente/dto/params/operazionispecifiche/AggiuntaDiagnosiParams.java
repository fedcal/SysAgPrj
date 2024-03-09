package com.mspaziente.dto.params.operazionispecifiche;

import lombok.Data;
import org.springframework.data.repository.query.Param;

@Data
public class AggiuntaDiagnosiParams {
    private Integer idCartellaClinica;

    private String tipoDiagnosi;
    private String descrizione;
}
