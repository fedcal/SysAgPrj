package com.bff.dto.mspaziente;

import com.bff.dto.msenciclopedia.MedicinaleDto;
import com.bff.dto.msinfermiere.InfermiereDto;
import lombok.Data;

@Data
public class MedicinaleSottoministrazioneDto {
    private Integer idRelazione;
    private InfermiereDto infermiere;
    private MedicinaleDto medicinale;
    private CartellaClinicaDto cartellaClinica;
}
