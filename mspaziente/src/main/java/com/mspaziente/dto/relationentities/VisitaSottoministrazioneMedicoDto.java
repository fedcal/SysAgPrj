package com.mspaziente.dto.relationentities;

import com.mspaziente.dto.CartellaClinicaDto;
import com.mspaziente.dto.MedicoDto;
import com.mspaziente.dto.visitamedica.VisitaMedicaDto;
import lombok.Data;

@Data
public class VisitaSottoministrazioneMedicoDto {
    private Integer idRelazione;
    private MedicoDto medico;
    private VisitaMedicaDto visitaMedica;
    private CartellaClinicaDto cartellaClinica;
}
