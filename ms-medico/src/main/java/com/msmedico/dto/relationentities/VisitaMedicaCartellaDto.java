package com.msmedico.dto.relationentities;

import com.msmedico.dto.paziente.CartellaClinicaDto;
import com.msmedico.dto.visitamedica.RefertoVisitaMedicaDto;
import com.msmedico.dto.visitamedica.VisitaMedicaDto;
import lombok.Data;

@Data
public class VisitaMedicaCartellaDto {
    private Integer idRelazione;
    private CartellaClinicaDto cartellaClinica;
    private VisitaMedicaDto visitaMedica;
    private RefertoVisitaMedicaDto refertoVisitaMedica;
}
