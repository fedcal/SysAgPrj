package com.mspaziente.dto.relationentities;


import com.mspaziente.dto.CartellaClinicaDto;
import com.mspaziente.dto.InfermiereDto;
import com.mspaziente.dto.visitamedica.VisitaMedicaDto;
import lombok.Data;

@Data
public class VisitaSottoministrazioneInfermiereDto {
    private Integer idRelazione;
    private InfermiereDto infermiere;
    private VisitaMedicaDto visitaMedica;
    private CartellaClinicaDto cartellaClinica;
}
