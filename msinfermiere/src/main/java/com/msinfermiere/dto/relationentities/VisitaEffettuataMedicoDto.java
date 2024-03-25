package com.msinfermiere.dto.relationentities;

import com.msinfermiere.dto.MedicoDto;
import com.msinfermiere.dto.paziente.CartellaClinicaDto;
import com.msinfermiere.dto.visitamedica.VisitaMedicaDto;
import lombok.Data;

@Data
public class VisitaEffettuataMedicoDto {
    private Integer idRelazione;
    private MedicoDto medico;
    private VisitaMedicaDto visitaMedica;
    private CartellaClinicaDto cartellaClinica;
}
