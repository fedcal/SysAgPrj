package com.mspaziente.dto.params.operazionigenerali;


import lombok.Data;

@Data
public class AddPazienteParams {
    private Integer idContattoRiferimento;
    private Integer idReparto;
    private Integer idCartellaClinica;

    private String nome;
    private String cognome;
    private String dataNascita;
    private String luogoNascita;
    private String provinciaNascita;
}
