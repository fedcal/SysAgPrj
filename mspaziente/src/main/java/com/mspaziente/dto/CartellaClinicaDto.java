package com.mspaziente.dto;

import com.mspaziente.dto.relationentities.*;
import lombok.Data;

import java.util.Set;

@Data
public class CartellaClinicaDto {
    private Integer idCartellaClinica;
    private String gruppoSanguigno;
    private Set<DiagnosiDto> diagnosi;
    private Set<MalattiaCartellaDto> malattiaCartella;
    private Set<MedicinaleCartellaDto> medicinaleCartella;
    private Set<MedicinalePrescrizioneDto> medicinalePrescrizione;
    private Set<MedicinaleSottoministrazioneDto> medicinaleSottoministrazione;
    private Set<OperazioneCartellaDto> operazioneCartella;
    private Set<OperazionePrescrizioneDto> operazionePrescrizione;
    private Set<VisitaMedicaCartellaDto> visitaMedicaCartella;
    private Set<VisitaPrescrizioneDto> visitaPrescrizione;
    private Set<VisitaSottoministrazioneMedicoDto> visitaSottoministrazioneMedico;
    private Set<VisitaSottoministrazioneInfermiereDto> visitaSottoministrazioneInfermiere;
}
