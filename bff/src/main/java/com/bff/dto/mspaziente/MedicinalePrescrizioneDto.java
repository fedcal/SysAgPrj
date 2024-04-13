package com.bff.dto.mspaziente;

import com.bff.dto.msenciclopedia.MedicinaleDto;
import com.bff.dto.msinfermiere.MedicoDto;
import lombok.Data;

@Data
public class MedicinalePrescrizioneDto {
    private Integer idRelazione;
    private MedicoDto medico;
    private MedicinaleDto medicinale;
    private CartellaClinicaDto cartellaClinica;
}
