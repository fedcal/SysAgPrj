package com.msinfermiere.dto.relationentities;

import com.msinfermiere.dto.MedicinaleDto;
import com.msinfermiere.dto.MedicoDto;
import com.msinfermiere.dto.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class MedicinalePrescrizioneDto {
    private Integer idRelazione;
    private MedicoDto medico;
    private MedicinaleDto medicinale;
    private CartellaClinicaDto cartellaClinica;
}
