package com.msinfo.dto.params.paziente;

import com.msinfo.dto.ContattoRiferimentoDto;
import com.msinfo.dto.ProfiloDto;
import com.msinfo.dto.RepartoDto;
import lombok.Data;

@Data
public class AddPazienteParams {
    private String nome;
    private String cognome;
    private String dataNascita;
    private String luogoNascita;
    private String provinciaNascita;
    private Integer contattoRiferimentoId;
    private Integer repartoId;
}
