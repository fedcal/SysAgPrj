package com.bff.dto.msmedico.relationentities;

import com.bff.dto.msmedico.MedicinaleDto;
import com.bff.dto.msmedico.MedicoDto;
import com.bff.dto.msmedico.paziente.CartellaClinicaDto;
import lombok.Data;

@Data
public class MedicinalePrescrizioneDto {
    private Integer idRelazione;
    private MedicoDto medico;
    private MedicinaleDto medicinale;
    private CartellaClinicaDto cartellaClinica;
}
