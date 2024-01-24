package com.msmedico.dto.relationentities;

import com.msmedico.dto.MedicinaleDto;
import com.msmedico.dto.MedicoDto;
import com.msmedico.dto.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class MedicinalePrescrizioneDto {
    private Integer idRelazione;
    private MedicoDto medico;
    private MedicinaleDto medicinale;
    private CartellaClinicaDto cartellaClinica;
}
