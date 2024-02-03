package com.msinfermiere.dto.relationentities;

import com.msinfermiere.dto.paziente.CartellaClinicaDto;
import com.msinfermiere.dto.visitamedica.RefertoVisitaMedicaDto;
import com.msinfermiere.dto.visitamedica.VisitaMedicaDto;
import lombok.Data;

@Data
public class VisitaMedicaCartellaDto {
    private Integer idRelazione;
    private CartellaClinicaDto cartellaClinica;
    private VisitaMedicaDto visitaMedica;
    private RefertoVisitaMedicaDto refertoVisitaMedica;
}
