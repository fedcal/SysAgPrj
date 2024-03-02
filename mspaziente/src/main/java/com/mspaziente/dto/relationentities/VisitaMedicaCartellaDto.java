package com.mspaziente.dto.relationentities;

import com.mspaziente.dto.CartellaClinicaDto;
import com.mspaziente.dto.visitamedica.RefertoVisitaMedicaDto;
import com.mspaziente.dto.visitamedica.VisitaMedicaDto;
import lombok.Data;

@Data
public class VisitaMedicaCartellaDto {
    private Integer idRelazione;
    private CartellaClinicaDto cartellaClinica;
    private VisitaMedicaDto visitaMedica;
    private RefertoVisitaMedicaDto refertoVisitaMedica;
}
