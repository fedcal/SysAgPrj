package com.bff.dto.msinfermiere.relationentities;

import com.bff.dto.msinfermiere.MedicoDto;
import com.bff.dto.msinfermiere.operazione.OperazioneMedicaDto;
import com.bff.dto.msinfermiere.operazione.RefertoOperazioneDto;
import com.bff.dto.msinfermiere.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class OperazioneCartellaDto {
    private Integer idRelazione;
    private OperazioneMedicaDto operazioneMedica;
    private CartellaClinicaDto cartellaClinica;
    private MedicoDto medico;
    private RefertoOperazioneDto refertoOperazione;
}
