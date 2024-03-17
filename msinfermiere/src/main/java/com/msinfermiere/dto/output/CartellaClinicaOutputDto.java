package com.msinfermiere.dto.output;

import com.msinfermiere.dto.paziente.DiagnosiDto;
import com.msinfermiere.dto.relationentities.*;
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
