package com.mspaziente.dto;

import com.mspaziente.dto.account.ProfiloDto;
import lombok.Data;

@Data
public class PazienteDto {
    private Integer idPaziente;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String luogoNascita;
    private String provinciaNascita;
    private ContattoRiferimentoDto contattoRiferimento;
    private RepartoDto reparto;
    private ProfiloDto profilo;
    private CartellaClinicaDto cartellaClinica;
}
