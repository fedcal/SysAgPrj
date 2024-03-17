package com.msmedico.dto.output;

import com.msmedico.dto.paziente.DiagnosiDto;
import com.msmedico.dto.relationentities.MalattiaCartellaDto;
import com.msmedico.dto.relationentities.MedicinaleCartellaDto;
import com.msmedico.dto.relationentities.MedicinalePrescrizioneDto;
import com.msmedico.dto.relationentities.OperazioneCartellaDto;
import com.msmedico.mspaziente.model.MedicinaleSottoministrazioneDto;
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
