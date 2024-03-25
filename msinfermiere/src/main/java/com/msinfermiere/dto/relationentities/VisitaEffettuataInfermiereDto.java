package com.msinfermiere.dto.relationentities;

import com.msinfermiere.dto.InfermiereDto;
import com.msinfermiere.dto.paziente.CartellaClinicaDto;
import com.msinfermiere.dto.visitamedica.VisitaMedicaDto;
import lombok.Data;

@Data
public class VisitaEffettuataInfermiereDto {
    private Integer idRelazione;
    private InfermiereDto infermiere;
    private VisitaMedicaDto visitaMedica;
    private CartellaClinicaDto cartellaClinica;
}
