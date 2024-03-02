package com.bff.service.msinfermiere;

import com.bff.dto.msinfermiere.params.medicinalioperazioni.FiltraMedicinalePrescrizioniParams;
import com.bff.dto.msinfermiere.params.medicinalioperazioni.FiltraMedicinaliSottoministrazioneParams;
import com.bff.dto.msinfermiere.params.medicinalioperazioni.SomministraMedicinaleParams;
import com.bff.dto.msinfermiere.relationentities.MedicinalePrescrizioneDto;
import com.bff.dto.msinfermiere.relationentities.MedicinaleSottoministrazioneDto;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.bff.msinfermiere.api.MsInfermieriMedicinaleOperazioniControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicinaleOperazioniInfermiereService {
    @Autowired
    private GenericResponseConverter genericResponseConverter;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private MsInfermieriMedicinaleOperazioniControllerApi medicinaleOperazioniControllerApi;

    public List<MedicinalePrescrizioneDto> getAllMedicinalePrescrizioni() {
        GenericResponseDto<List<MedicinalePrescrizioneDto>> allMedicinalePrescrizioni = genericResponseConverter.convertGenericResponseList(
                medicinaleOperazioniControllerApi.msInfermiereListaPrescrizioniMedicinali(),MedicinalePrescrizioneDto.class
        );
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(allMedicinalePrescrizioni.getEsito().getMessaggi());
        return allMedicinalePrescrizioni.getPayload();
    }

    public List<MedicinalePrescrizioneDto> getPrescrizioniMedicinaliFiltrati(FiltraMedicinalePrescrizioniParams params) {
        GenericResponseDto<List<MedicinalePrescrizioneDto>> allMedicinalePrescrizioniFiltrati = genericResponseConverter.convertGenericResponseList(
                medicinaleOperazioniControllerApi.msInfermiereListaPrescrizioniMedicinaliFiltrati(params.getIdPrescrizioneMedicinale(), params.getIdMedico(),
                        params.getIdMedicinale(), params.getIdCartellaClinica(), params.getNomeMedico(), params.getCognomeMedico(),
                        params.getNomeMedicinale(), params.getNomePaziente(), params.getCognomePaziente()),
                MedicinalePrescrizioneDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(allMedicinalePrescrizioniFiltrati.getEsito().getMessaggi());
        return allMedicinalePrescrizioniFiltrati.getPayload();
    }

    public List<MedicinaleSottoministrazioneDto> getAllMedicinaleSottoministrazioni() {
        GenericResponseDto<List<MedicinaleSottoministrazioneDto>> allMedicinaleSottoministrazioni = genericResponseConverter.convertGenericResponseList(
                medicinaleOperazioniControllerApi.msInfermiereListaSottoministrazioneMedicinali(),
                MedicinaleSottoministrazioneDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(allMedicinaleSottoministrazioni.getEsito().getMessaggi());
        return allMedicinaleSottoministrazioni.getPayload();
    }

    public List<MedicinaleSottoministrazioneDto> getAllMedicinaleSottoministrazioniFiltrata(FiltraMedicinaliSottoministrazioneParams params) {
        GenericResponseDto<List<MedicinaleSottoministrazioneDto>> allMedicinaleSottoministrazioniFiltrata = genericResponseConverter.convertGenericResponseList(
                medicinaleOperazioniControllerApi.msInfermiereListaSottoministrazioneMedicinaliFiltrata(params.getIdPrescrizioneMedicinale(), params.getIdMedico(), params.getIdMedicinale(), params.getIdCartellaClinica(),
                        params.getNomeMedico(), params.getCognomeMedico(), params.getNomeMedicinale(), params.getNomePaziente(), params.getCognomePaziente()),
                MedicinaleSottoministrazioneDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(allMedicinaleSottoministrazioniFiltrata.getEsito().getMessaggi());
        return allMedicinaleSottoministrazioniFiltrata.getPayload();
    }

    public MedicinaleSottoministrazioneDto somministraMedicinale(SomministraMedicinaleParams params) {
        GenericResponseDto<MedicinaleSottoministrazioneDto> somministraMedicinaleReturn = genericResponseConverter.convertGenericResponse(
                medicinaleOperazioniControllerApi.msInfermiereSomministraMedicinale(params.getInfermiere(), params.getMedicinale(), params.getCartellaClinica()),
                MedicinaleSottoministrazioneDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(somministraMedicinaleReturn.getEsito().getMessaggi());
        return somministraMedicinaleReturn.getPayload();
    }
}
