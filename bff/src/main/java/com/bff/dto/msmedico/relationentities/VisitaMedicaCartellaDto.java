package com.bff.dto.msmedico.relationentities;

import com.bff.dto.msmedico.paziente.CartellaClinicaDto;
import com.bff.dto.msmedico.visitamedica.RefertoVisitaMedicaDto;
import com.bff.dto.msmedico.visitamedica.VisitaMedicaDto;
import lombok.Data;

@Data
public class VisitaMedicaCartellaDto {
    private Integer idRelazione;
    private CartellaClinicaDto cartellaClinica;
    private VisitaMedicaDto visitaMedica;
    private RefertoVisitaMedicaDto refertoVisitaMedica;
}
