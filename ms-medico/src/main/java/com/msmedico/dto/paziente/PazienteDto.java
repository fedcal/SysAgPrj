package com.msmedico.dto.paziente;

import com.msmedico.dto.RepartoDto;
import com.msmedico.dto.account.ProfiloDto;
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
