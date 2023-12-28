package com.bff.dto.msinfo;

import lombok.Data;

@Data
public class RepartoInfermiereDto {
    private Integer idRelazione;
    private RepartoDto reparto;
    private InfermiereDto infermiere;
}
