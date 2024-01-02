package com.msmedico.dto.relationentities;


import com.msmedico.dto.MalattiaDto;
import com.msmedico.dto.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class MalattiaCartellaDto {
    private Integer idRelazione;
    private MalattiaDto malattia;
    private CartellaClinicaDto cartellaClinica;
}
