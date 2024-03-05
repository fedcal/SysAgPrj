package com.mspaziente.dto.params.operazionigenerali;

import lombok.Data;

@Data
public class FindPazienteParams {
    private Integer idPaziente;
    private String nome;
    private String cognome;
    private String dataNascita;
}
