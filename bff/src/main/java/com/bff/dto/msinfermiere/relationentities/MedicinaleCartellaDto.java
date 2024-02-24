package com.bff.dto.msinfermiere.relationentities;

import com.bff.dto.msinfermiere.MedicinaleDto;
import com.bff.dto.msinfermiere.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class MedicinaleCartellaDto {
    private Integer idRelazione;
    private MedicinaleDto medicinale;
    private CartellaClinicaDto cartellaClinica;
}
