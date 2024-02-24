package com.bff.dto.msinfermiere.relationentities;

import com.bff.dto.msinfermiere.MalattiaDto;
import com.bff.dto.msinfermiere.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class MalattiaCartellaDto {
    private Integer idRelazione;
    private MalattiaDto malattia;
    private CartellaClinicaDto cartellaClinica;
}
