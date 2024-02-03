package com.bff.dto.msmedico.paziente;

import com.bff.dto.msmedico.relationentities.*;
import lombok.Data;

import java.util.Set;
@Data
public class CartellaClinicaDto {
    private Integer idCartellaClinica;
    private String gruppoSanguigno;
    private PazienteDto paziente;
    private Set<DiagnosiDto> diagnosi;
    private Set<MalattiaCartellaDto> malattiaCartella;
    private Set<VisitaMedicaCartellaDto> visitaMedicaCartella;
    private Set<OperazioneCartellaDto> operazioneCartella;
    private Set<MedicinalePrescrizioneDto> medicinalePrescrizione;
    private Set<VisitaPrescrizioneDto> visitaPrescrizione;
    private Set<VisitaSottoministrazioneMedicoDto> visitaSottoministrazioneMedico;
    private Set<MedicinaleCartellaDto> medicinaleCartella;
    private Set<OperazionePrescrizioneDto> operazionePrescrizione;
}
