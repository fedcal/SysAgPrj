package com.msinfo.dto.params.profilo;

import lombok.Data;

@Data
public class ProfiloAggiornamentoParams {
    private Integer idProfilo;

    private String nuovoTipo;
    private String nuovoDescrizione;
}
