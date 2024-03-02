package com.mspaziente.dto;

import com.mspaziente.dto.relationentities.*;
import com.mspaziente.entity.Diagnosi;
import com.mspaziente.entity.Paziente;
import com.mspaziente.entity.relationentities.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
public class CartellaClinicaDto {
    private Integer idCartellaClinica;
    private String gruppoSanguigno;
    private Paziente paziente;
    private Set<DiagnosiDto> diagnosi;
    private Set<MalattiaCartellaDto> malattiaCartella;
    private Set<VisitaMedicaCartellaDto> visitaMedicaCartella;
    private Set<OperazioneCartellaDto> operazioneCartella;
    private Set<MedicinalePrescrizioneDto> medicinalePrescrizione;
    private Set<VisitaPrescrizioneDto> visitaPrescrizione;
    private Set<VisitaSottoministrazioneMedicoDto> visitaSottoministrazioneMedico;
    private Set<VisitaSottoministrazioneInfermiereDto> visitaSottoministrazioneInfermiere;
    private Set<MedicinaleCartellaDto> medicinaleCartella;
    private Set<OperazionePrescrizioneDto> operazionePrescrizione;
    private Set<MedicinaleSottoministrazioneDto> medicinaleSottoministrazione;
}
