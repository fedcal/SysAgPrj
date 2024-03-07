package com.mspaziente.dto.output;

import com.mspaziente.dto.DiagnosiDto;
import com.mspaziente.dto.relationentities.*;
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
