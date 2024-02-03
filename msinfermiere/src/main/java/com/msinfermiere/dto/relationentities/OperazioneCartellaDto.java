package com.msinfermiere.dto.relationentities;

import com.msinfermiere.dto.MedicoDto;
import com.msinfermiere.dto.operazione.OperazioneMedicaDto;
import com.msinfermiere.dto.operazione.RefertoOperazioneDto;
import com.msinfermiere.dto.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class OperazioneCartellaDto {
    private Integer idRelazione;
    private OperazioneMedicaDto operazioneMedica;
    private CartellaClinicaDto cartellaClinica;
    private MedicoDto medico;
    private RefertoOperazioneDto refertoOperazione;
}
