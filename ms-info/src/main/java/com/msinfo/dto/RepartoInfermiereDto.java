package com.msinfo.dto;

import com.msinfo.entity.infermieri.Infermiere;
import com.msinfo.entity.reparto.Reparto;
import lombok.Data;

@Data
public class RepartoInfermiereDto {
    private Integer idRelazione;
    private Reparto reparto;
    private Infermiere infermiere;
}
