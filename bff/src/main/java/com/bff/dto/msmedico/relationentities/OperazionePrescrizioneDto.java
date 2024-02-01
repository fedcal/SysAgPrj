package com.bff.dto.msmedico.relationentities;

import com.bff.dto.msmedico.MedicoDto;
import com.bff.dto.msmedico.operazione.OperazioneMedicaDto;
import com.bff.dto.msmedico.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class OperazionePrescrizioneDto {
    private Integer idRelazione;
    private OperazioneMedicaDto operazioneMedica;
    private CartellaClinicaDto cartellaClinica;
    private MedicoDto medico;
}
