package com.mspaziente.dto.relationentities;

import com.mspaziente.dto.CartellaClinicaDto;
import com.mspaziente.dto.MedicoDto;
import com.mspaziente.dto.operazione.OperazioneMedicaDto;
import lombok.Data;

@Data
public class OperazionePrescrizioneDto {
    private Integer idRelazione;
    private OperazioneMedicaDto operazioneMedica;
    private CartellaClinicaDto cartellaClinica;
    private MedicoDto medico;
}
