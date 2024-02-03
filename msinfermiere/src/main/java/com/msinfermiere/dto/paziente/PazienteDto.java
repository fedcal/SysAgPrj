package com.msinfermiere.dto.paziente;

import com.msinfermiere.dto.RepartoDto;
import com.msinfermiere.dto.account.ProfiloDto;
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
