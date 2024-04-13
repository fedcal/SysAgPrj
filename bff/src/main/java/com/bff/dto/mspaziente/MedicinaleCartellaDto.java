package com.bff.dto.mspaziente;

import com.bff.dto.msenciclopedia.MedicinaleDto;
import lombok.Data;

@Data
public class MedicinaleCartellaDto {
    private Integer idRelazione;
    private MedicinaleDto medicinale;
    private CartellaClinicaDto cartellaClinica;
}
