package com.mspaziente.dto.relationentities;

import com.mspaziente.dto.CartellaClinicaDto;
import com.mspaziente.dto.MedicinaleDto;
import com.mspaziente.dto.MedicoDto;
import lombok.Data;

@Data
public class MedicinalePrescrizioneDto {
    private Integer idRelazione;
    private MedicoDto medico;
    private MedicinaleDto medicinale;
    private CartellaClinicaDto cartellaClinica;
}
