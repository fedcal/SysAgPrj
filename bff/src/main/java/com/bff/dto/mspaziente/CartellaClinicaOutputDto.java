package com.bff.dto.mspaziente;

import com.bff.dto.msinfermiere.relationentities.*;
import com.bff.dto.msmedico.paziente.DiagnosiDto;
import lombok.Data;

import java.util.List;
@Data
public class CartellaClinicaOutputDto {
    List<DiagnosiDto> diagnosi;
    List<MalattiaCartellaDto> malattie;
    List<MedicinaleCartellaDto> medicinali;
    List<MedicinalePrescrizioneDto> medicinaliPrescritti;
    List<MedicinaleSottoministrazioneDto> medicinaliSottoministrti;
    List<OperazioneCartellaDto> operazioni;
}
