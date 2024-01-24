package com.msmedico.dto.relationentities;

import com.msmedico.dto.MedicoDto;
import com.msmedico.dto.operazione.OperazioneMedicaDto;
import com.msmedico.dto.operazione.RefertoOperazioneDto;
import com.msmedico.dto.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class OperazioneCartellaDto {
    private Integer idRelazione;
    private OperazioneMedicaDto operazioneMedica;
    private CartellaClinicaDto cartellaClinica;
    private MedicoDto medico;
    private RefertoOperazioneDto refertoOperazione;
}
