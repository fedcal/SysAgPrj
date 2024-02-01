package com.bff.dto.msmedico.relationentities;


import com.bff.dto.msmedico.MedicinaleDto;
import com.bff.dto.msmedico.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class MedicinaleCartellaDto {
    private Integer idRelazione;
    private MedicinaleDto medicinale;
    private CartellaClinicaDto cartellaClinica;
}
