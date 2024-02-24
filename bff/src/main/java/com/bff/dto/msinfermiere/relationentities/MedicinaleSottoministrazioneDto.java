package com.bff.dto.msinfermiere.relationentities;

import com.bff.dto.msinfermiere.InfermiereDto;
import com.bff.dto.msinfermiere.MedicinaleDto;
import com.bff.dto.msinfermiere.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class MedicinaleSottoministrazioneDto {
    private Integer idRelazione;
    private InfermiereDto infermiere;
    private MedicinaleDto medicinale;
    private CartellaClinicaDto cartellaClinica;
}
