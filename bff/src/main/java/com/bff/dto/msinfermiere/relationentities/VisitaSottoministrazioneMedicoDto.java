package com.bff.dto.msinfermiere.relationentities;

import com.bff.dto.msinfermiere.MedicoDto;
import com.bff.dto.msinfermiere.paziente.CartellaClinicaDto;
import com.bff.dto.msinfermiere.visitamedica.VisitaMedicaDto;
import lombok.Data;

@Data
public class VisitaSottoministrazioneMedicoDto {
    private Integer idRelazione;
    private MedicoDto medico;
    private VisitaMedicaDto visitaMedica;
    private CartellaClinicaDto cartellaClinica;
}
