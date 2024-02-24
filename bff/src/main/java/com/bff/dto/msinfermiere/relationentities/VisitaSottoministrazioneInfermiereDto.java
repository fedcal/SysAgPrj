package com.bff.dto.msinfermiere.relationentities;

import com.bff.dto.msinfermiere.InfermiereDto;
import com.bff.dto.msinfermiere.paziente.CartellaClinicaDto;
import com.bff.dto.msinfermiere.visitamedica.VisitaMedicaDto;
import lombok.Data;

@Data
public class VisitaSottoministrazioneInfermiereDto {
    private Integer idRelazione;
    private InfermiereDto infermiere;
    private VisitaMedicaDto visitaMedica;
    private CartellaClinicaDto cartellaClinica;
}
