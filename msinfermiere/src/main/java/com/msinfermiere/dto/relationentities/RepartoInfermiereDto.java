package com.msinfermiere.dto.relationentities;

import com.msinfermiere.dto.InfermiereDto;
import com.msinfermiere.dto.RepartoDto;
import lombok.Data;

@Data
public class RepartoInfermiereDto {
    private Integer idRelazione;
    private RepartoDto reparto;
    private InfermiereDto infermiere;
}
