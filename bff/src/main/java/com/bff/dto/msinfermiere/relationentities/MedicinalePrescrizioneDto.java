package com.bff.dto.msinfermiere.relationentities;

import com.bff.dto.msinfermiere.MedicinaleDto;
import com.bff.dto.msinfermiere.MedicoDto;
import com.bff.dto.msinfermiere.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class MedicinalePrescrizioneDto {
    private Integer idRelazione;
    private MedicoDto medico;
    private MedicinaleDto medicinale;
    private CartellaClinicaDto cartellaClinica;
}
