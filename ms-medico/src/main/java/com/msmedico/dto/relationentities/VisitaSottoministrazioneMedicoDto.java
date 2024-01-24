package com.msmedico.dto.relationentities;

import com.msmedico.dto.MedicoDto;
import com.msmedico.dto.paziente.CartellaClinicaDto;
import com.msmedico.dto.visitamedica.VisitaMedicaDto;
import lombok.Data;

@Data
public class VisitaSottoministrazioneMedicoDto {
    private Integer idRelazione;
    private MedicoDto medico;
    private VisitaMedicaDto visitaMedica;
    private CartellaClinicaDto cartellaClinica;
}
