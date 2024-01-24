package com.msmedico.dto.relationentities;

import com.msmedico.dto.MedicinaleDto;
import com.msmedico.dto.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class MedicinaleCartellaDto {
    private Integer idRelazione;
    private MedicinaleDto medicinale;
    private CartellaClinicaDto cartellaClinica;
}
