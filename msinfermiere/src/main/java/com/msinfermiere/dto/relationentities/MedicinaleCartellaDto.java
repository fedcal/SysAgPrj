package com.msinfermiere.dto.relationentities;

import com.msinfermiere.dto.MedicinaleDto;
import com.msinfermiere.dto.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class MedicinaleCartellaDto {
    private Integer idRelazione;
    private MedicinaleDto medicinale;
    private CartellaClinicaDto cartellaClinica;
}
