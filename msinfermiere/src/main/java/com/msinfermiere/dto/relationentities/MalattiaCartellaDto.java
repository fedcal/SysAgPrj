package com.msinfermiere.dto.relationentities;

import com.msinfermiere.dto.MalattiaDto;
import com.msinfermiere.dto.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class MalattiaCartellaDto {
    private Integer idRelazione;
    private MalattiaDto malattia;
    private CartellaClinicaDto cartellaClinica;
}
