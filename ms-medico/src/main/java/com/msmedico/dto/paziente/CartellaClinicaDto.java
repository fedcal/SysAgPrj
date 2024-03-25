package com.msmedico.dto.paziente;

import com.msmedico.dto.relationentities.*;
import lombok.Data;

import java.util.Set;

@Data
public class CartellaClinicaDto {
    private Integer idCartellaClinica;
    private String gruppoSanguigno;
    private Set<DiagnosiDto> diagnosi;
    private Set<MalattiaCartellaDto> malattiaCartella;
    private Set<VisitaMedicaCartellaDto> visitaMedicaCartella;
    private Set<OperazioneCartellaDto> operazioneCartella;
    private Set<MedicinalePrescrizioneDto> medicinalePrescrizione;
    private Set<VisitaPrescrizioneDto> visitaPrescrizione;
    private Set<VisitaEffettuataMedicoDto> visitaSottoministrazioneMedico;
    private Set<MedicinaleCartellaDto> medicinaleCartella;
    private Set<OperazionePrescrizioneDto> operazionePrescrizione;
}
