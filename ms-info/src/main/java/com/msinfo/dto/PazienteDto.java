package com.msinfo.dto;

import com.msinfo.entity.account.Profilo;
import com.msinfo.entity.pazienti.ContattoRiferimento;
import com.msinfo.entity.reparto.Reparto;
import lombok.Data;

@Data
public class PazienteDto {
    private Integer idPaziente;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String luogoNascita;
    private String provinciaNascita;
    private ContattoRiferimento contattoRiferimento;
    private Reparto reparto;
    private Profilo profilo;
}
