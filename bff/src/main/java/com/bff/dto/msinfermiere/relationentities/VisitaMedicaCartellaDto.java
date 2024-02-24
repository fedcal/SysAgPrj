package com.bff.dto.msinfermiere.relationentities;

import com.bff.dto.msinfermiere.paziente.CartellaClinicaDto;
import com.bff.dto.msinfermiere.visitamedica.RefertoVisitaMedicaDto;
import com.bff.dto.msinfermiere.visitamedica.VisitaMedicaDto;
import lombok.Data;

@Data
public class VisitaMedicaCartellaDto {
    private Integer idRelazione;
    private CartellaClinicaDto cartellaClinica;
    private VisitaMedicaDto visitaMedica;
    private RefertoVisitaMedicaDto refertoVisitaMedica;
}
