package com.bff.dto.msmedico.relationentities;

import com.bff.dto.msmedico.MalattiaDto;
import com.bff.dto.msmedico.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class MalattiaCartellaDto {
    private Integer idRelazione;
    private MalattiaDto malattia;
    private CartellaClinicaDto cartellaClinica;
}
