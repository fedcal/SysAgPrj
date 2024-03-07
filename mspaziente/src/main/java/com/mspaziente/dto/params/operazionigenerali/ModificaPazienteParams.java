package com.mspaziente.dto.params.operazionigenerali;

import lombok.Data;

@Data
public class ModificaPazienteParams {
    private Integer idPaziente;

    private String nuvoNome;
    private String nuovoCognome;
    private String nuovaDataNascita;
    private String nuovoLuogoNascita;
    private String nuovaProvinciaNascita;

    private Integer idContattoRiferimento;
    private Integer idReparto;
    private Integer idCartellaClinica;
}
