package com.msinfo.dto.params.paziente;

import lombok.Data;

@Data
public class ModificaPazienteParams {
    private Integer idPazinente;

    private String nuovoNome;
    private String nuovoCognome;
    private String nuovaDataNascita;
    private String nuovoLuogoNascita;
    private String nuovaProvinciaNascita;
    private Integer nuovoContattoRiferimentoId;
    private Integer nuovoRepartoId;
}
