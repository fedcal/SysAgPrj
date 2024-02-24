package com.bff.dto.msinfermiere.relationentities;

import com.bff.dto.msinfermiere.InfermiereDto;
import com.bff.dto.msinfermiere.RepartoDto;
import lombok.Data;

@Data
public class RepartoInfermiereDto {
    private Integer idRelazione;
    private RepartoDto reparto;
    private InfermiereDto infermiere;
}
