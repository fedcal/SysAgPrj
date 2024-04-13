package com.bff.service.mspaziente;

import com.bff.controller.mspaziente.CartellaClinicaCreazioneController;
import com.bff.dto.msenciclopedia.SintomoDto;
import com.bff.dto.mspaziente.*;
import com.bff.dto.mspaziente.params.malattiacontroller.*;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.bff.mspaziente.api.MsPazienteCartellaClinicaCreazioneControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OperazioniSpecificheService {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private GenericResponseConverter genericResponseConverter;

    @Autowired
    private MsPazienteCartellaClinicaCreazioneControllerApi cartellaClinicaCreazioneController;


    public CartellaClinicaOutputDto findCartellaClinica(FindCartellaClinicaParams params) {
        GenericResponseDto<CartellaClinicaOutputDto> findCartellaClinica = genericResponseConverter.convertGenericResponse(
                cartellaClinicaCreazioneController.msPazienteVisualizzaCartellaClinica(params.getIdCartellaClinica(),
                        params.getIdPaziente()),CartellaClinicaOutputDto.class
        );
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(findCartellaClinica.getEsito().getMessaggi());
        return findCartellaClinica.getPayload();
    }

    public CartellaClinicaDto aggiungiCartellaClinica(AggiungiCartellaClinicaParams params) {
        GenericResponseDto<CartellaClinicaDto> aggiungiCartellaClinica = genericResponseConverter.convertGenericResponse(
                cartellaClinicaCreazioneController.msPazienteAggiungiCartellaClinica(params.getGruppoSanguigno(), params.getIdPaziente()),CartellaClinicaDto.class
        );
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(aggiungiCartellaClinica.getEsito().getMessaggi());
        return aggiungiCartellaClinica.getPayload();
    }

    public DiagnosiDto aggiungiDiagnosi(AggiuntaDiagnosiParams params) {
        GenericResponseDto<DiagnosiDto> aggiungiDiagnosi = genericResponseConverter.convertGenericResponse(
                cartellaClinicaCreazioneController.msPazienteAggiungiDiagnosiCartellaClinca(params.getIdCartellaClinica(),
                        params.getTipoDiagnosi(), params.getDescrizione()),DiagnosiDto.class
        );
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(aggiungiDiagnosi.getEsito().getMessaggi());
        return aggiungiDiagnosi.getPayload();
    }

    public MalattiaCartellaDto aggiungiMalattia(AggiungiMalattiaParams params) {
        GenericResponseDto<MalattiaCartellaDto> aggiungiMalattia = genericResponseConverter.convertGenericResponse(
                cartellaClinicaCreazioneController.msPazienteAggiungiMalattiaCartellaClinca(params.getIdCartellaClinica(),
                        params.getIdMalattia()),MalattiaCartellaDto.class
        );
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(aggiungiMalattia.getEsito().getMessaggi());
        return aggiungiMalattia.getPayload();
    }

    public MedicinaleCartellaDto aggiungiMedicinale(AggiungiMedicinaleParams params) {
        GenericResponseDto<MedicinaleCartellaDto> aggiungiMedicinale = genericResponseConverter.convertGenericResponse(
                cartellaClinicaCreazioneController.msPazienteAggiungiMalattiaCartellaClinca(params.getIdCartellaClinica(),
                        params.getIdMedicinale()),MedicinaleCartellaDto.class
        );
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(aggiungiMedicinale.getEsito().getMessaggi());
        return aggiungiMedicinale.getPayload();
    }

    public MedicinalePrescrizioneDto aggiungiPrescrizioneMedicinale(AggiungiPrescrizioneMedicinaleParams params) {
        GenericResponseDto<MedicinalePrescrizioneDto> aggiungiMedicinale = genericResponseConverter.convertGenericResponse(
                cartellaClinicaCreazioneController.msPazienteAggiungiPrescrizioneMedicinaleCartellaClinca(params.getIdMedico(),
                        params.getIdCartellaClinica(), params.getIdCartellaClinica(), params.getIdVisita()),MedicinalePrescrizioneDto.class
        );
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(aggiungiMedicinale.getEsito().getMessaggi());
        return aggiungiMedicinale.getPayload();
    }

    public MedicinaleSottoministrazioneDto aggiungiMedicinalePrescrizione(AggiungiMedicinaleSottoministrazioneParams params) {
        GenericResponseDto<MedicinaleSottoministrazioneDto> aggiungiMedicinale = genericResponseConverter.convertGenericResponse(
                cartellaClinicaCreazioneController.msPazienteAggiungiPrescrizioneMedicinalePrescrizione(params.getIdInfermiere(), params.getIdMedicinale(),
                        params.getIdCartellaClinica()),
                MedicinaleSottoministrazioneDto.class
        );
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(aggiungiMedicinale.getEsito().getMessaggi());
        return aggiungiMedicinale.getPayload();
    }
}
