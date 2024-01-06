package com.msmedico.service;

import com.msmedico.dto.params.visualizzastato.FindCartellaClinicaParams;
import com.msmedico.dto.relationentities.OperazionePrescrizioneDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrescrizioneService {
    public List<OperazionePrescrizioneDto> prescriviOperazione(FindCartellaClinicaParams params) {
        return new ArrayList<>();
    }
}
