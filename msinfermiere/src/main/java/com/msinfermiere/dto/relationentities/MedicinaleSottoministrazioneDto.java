package com.msinfermiere.dto.relationentities;

import com.msinfermiere.dto.InfermiereDto;
import com.msinfermiere.dto.MedicinaleDto;
import com.msinfermiere.dto.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class MedicinaleSottoministrazioneDto {
    private Integer idRelazione;
    private InfermiereDto infermiere;
    private MedicinaleDto medicinale;
    private CartellaClinicaDto cartellaClinica;
}
