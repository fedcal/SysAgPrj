package com.bff.dto.msmedico.relationentities;

import com.bff.dto.msmedico.MedicoDto;
import com.bff.dto.msmedico.paziente.CartellaClinicaDto;
import com.bff.dto.msmedico.visitamedica.VisitaMedicaDto;
import lombok.Data;

@Data
public class VisitaSottoministrazioneMedicoDto {
    private Integer idRelazione;
    private MedicoDto medico;
    private VisitaMedicaDto visitaMedica;
    private CartellaClinicaDto cartellaClinica;
}
