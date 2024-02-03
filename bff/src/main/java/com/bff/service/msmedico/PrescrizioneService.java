package com.bff.service.msmedico;

import com.bff.dto.msmedico.params.prescrizione.medicinale.PrescrizioneMedicinaleAddParams;
import com.bff.dto.msmedico.params.prescrizione.medicinale.PrescrizioneMedicinaleInfoParams;
import com.bff.dto.msmedico.params.prescrizione.medicinale.PrescrizioneMedicinaleModifyParams;
import com.bff.dto.msmedico.params.prescrizione.operazione.PrescrizioneOperazioneAddParams;
import com.bff.dto.msmedico.params.prescrizione.operazione.PrescrizioneOperazioneInfoParams;
import com.bff.dto.msmedico.params.prescrizione.operazione.PrescrizioneOperazioneModifyParams;
import com.bff.dto.msmedico.params.prescrizione.visita.PrescrizioneVisitaAddParams;
import com.bff.dto.msmedico.params.prescrizione.visita.PrescrizioneVisitaInfoParams;
import com.bff.dto.msmedico.params.prescrizione.visita.PrescrizioneVisitaModifyParams;
import com.bff.dto.msmedico.relationentities.MedicinalePrescrizioneDto;
import com.bff.dto.msmedico.relationentities.OperazionePrescrizioneDto;
import com.bff.dto.msmedico.relationentities.VisitaPrescrizioneDto;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.bff.msmedico.api.PrescrizioneControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescrizioneService {
    @Autowired
    private GenericResponseConverter genericResponseConverter;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
    @Autowired
    private PrescrizioneControllerApi prescrizioneControllerApi;
    public List<OperazionePrescrizioneDto> prescriviOperazioneInfo(PrescrizioneOperazioneInfoParams params) {
        GenericResponseDto<List<OperazionePrescrizioneDto>> prescriviOperazioneInfo = genericResponseConverter.convertGenericResponseList(
                prescrizioneControllerApi.msMedicoPrescriviOperazioneInfo(params.getIdMedico(), params.getIdCartella(),
                        params.getIdOperazione(), params.getIdPaziente(), params.getNomeOperazione(), params.getNomeMedico(),
                        params.getCognomeMedico(), params.getNomePaziente(), params.getCognomePaziente()), OperazionePrescrizioneDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(prescriviOperazioneInfo.getEsito().getMessaggi());
        return prescriviOperazioneInfo.getPayload();
    }

    public OperazionePrescrizioneDto prescriviOperazioneAdd(PrescrizioneOperazioneAddParams params) {
        GenericResponseDto<OperazionePrescrizioneDto> prescriviOperazioneAdd = genericResponseConverter.convertGenericResponse(
                prescrizioneControllerApi.msMedicoPrescriviOperazioneAdd(params.getOperazioneMedica(), params.getCartellaClinica(),
                        params.getMedico()), OperazionePrescrizioneDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(prescriviOperazioneAdd.getEsito().getMessaggi());
        return prescriviOperazioneAdd.getPayload();
    }

    public OperazionePrescrizioneDto prescriviOperazioneModify(PrescrizioneOperazioneModifyParams params) {
        GenericResponseDto<OperazionePrescrizioneDto> prescriviOperazioneModify = genericResponseConverter.convertGenericResponse(
                prescrizioneControllerApi.msMedicoPrescriviOperazioneModify(params.getIdRelazione(), params.getNuovaOperazioneMedica(),
                        params.getNuovaCartellaClinica(), params.getNuovoMedico()), OperazionePrescrizioneDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(prescriviOperazioneModify.getEsito().getMessaggi());
        return prescriviOperazioneModify.getPayload();
    }

    public String prescriviOperazioneDelete(Integer params) {
        GenericResponseDto<String> prescriviOperazioneDelete = genericResponseConverter.convertGenericResponse(
                prescrizioneControllerApi.msMedicoPrescriviOperazioneDelete(params), String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(prescriviOperazioneDelete.getEsito().getMessaggi());
        return prescriviOperazioneDelete.getPayload();
    }

    public List<MedicinalePrescrizioneDto> prescriviMedicinaleInfo(PrescrizioneMedicinaleInfoParams params) {
        GenericResponseDto<List<MedicinalePrescrizioneDto>> prescriviMedicinaleInfo = genericResponseConverter.convertGenericResponseList(
                prescrizioneControllerApi.msMedicoPrescriviMedicinaleInfo(params.getIdRelazione(), params.getIdMedico(),
                        params.getIdMedicinale(), params.getIdCartellaClinica(), params.getIdPaziente(), params.getNomeMedico(),
                        params.getCognomeMedico(), params.getNomePaziente(), params.getCognomePaziente(), params.getNomeMedicinale()), MedicinalePrescrizioneDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(prescriviMedicinaleInfo.getEsito().getMessaggi());
        return prescriviMedicinaleInfo.getPayload();
    }

    public String prescriviMedicinaleDelete(Integer params) {
        GenericResponseDto<String> prescriviMedicinaleDelete = genericResponseConverter.convertGenericResponse(
                prescrizioneControllerApi.msMedicoPrescriviMedicinaleDelete(params), String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(prescriviMedicinaleDelete.getEsito().getMessaggi());
        return prescriviMedicinaleDelete.getPayload();
    }

    public MedicinalePrescrizioneDto prescriviMedicinaleAdd(PrescrizioneMedicinaleAddParams params) {
        GenericResponseDto<MedicinalePrescrizioneDto> prescriviMedicinaleAdd = genericResponseConverter.convertGenericResponse(
                prescrizioneControllerApi.msMedicoPrescriviMedicinaleAdd(params.getIdMedico(), params.getIdMedicinale(), params.getIdCartellaClinica()), MedicinalePrescrizioneDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(prescriviMedicinaleAdd.getEsito().getMessaggi());
        return prescriviMedicinaleAdd.getPayload();
    }

    public MedicinalePrescrizioneDto prescriviMedicinaleModify(PrescrizioneMedicinaleModifyParams params) {
        GenericResponseDto<MedicinalePrescrizioneDto> prescriviMedicinaleModify = genericResponseConverter.convertGenericResponse(
                prescrizioneControllerApi.msMedicoPrescriviMedicinaleModify(params.getIdRelazione(), params.getNuovoMedicinale(),
                        params.getNuovaCartellaClinica(), params.getNuovoMedico()), MedicinalePrescrizioneDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(prescriviMedicinaleModify.getEsito().getMessaggi());
        return prescriviMedicinaleModify.getPayload();
    }

    public List<VisitaPrescrizioneDto> prescriviVisitaInfo(PrescrizioneVisitaInfoParams params) {
        GenericResponseDto<List<VisitaPrescrizioneDto>> prescriviVisitaInfo = genericResponseConverter.convertGenericResponseList(
                prescrizioneControllerApi.msMedicoprescriviVisitaInfo(params.getIdRelazione(), params.getIdMedico(),
                        params.getIdCartella(), params.getIdVisita(), params.getIdPaziente(), params.getNomeVisita(),
                        params.getNomeMedico(), params.getCognomeMedico(), params.getNomePaziente(), params.getCognomePaziente()), VisitaPrescrizioneDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(prescriviVisitaInfo.getEsito().getMessaggi());
        return prescriviVisitaInfo.getPayload();
    }

    public VisitaPrescrizioneDto prescriviVisitaAdd(PrescrizioneVisitaAddParams params) {
        GenericResponseDto<VisitaPrescrizioneDto> prescriviVisitaAdd = genericResponseConverter.convertGenericResponse(
                prescrizioneControllerApi.msMedicoprescriviVisitaAdd(params.getVisitaMedica(), params.getCartellaClinica(),
                        params.getMedico()), VisitaPrescrizioneDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(prescriviVisitaAdd.getEsito().getMessaggi());
        return prescriviVisitaAdd.getPayload();
    }

    public String prescriviVisitaDelete(Integer params) {
        GenericResponseDto<String> prescriviVisitaDelete = genericResponseConverter.convertGenericResponse(
                prescrizioneControllerApi.msMedicoprescriviVisitaDelete(params), String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(prescriviVisitaDelete.getEsito().getMessaggi());
        return prescriviVisitaDelete.getPayload();
    }

    public VisitaPrescrizioneDto prescriviVisitaModify(PrescrizioneVisitaModifyParams params) {
        GenericResponseDto<VisitaPrescrizioneDto> prescriviVisitaModify = genericResponseConverter.convertGenericResponse(
                prescrizioneControllerApi.msMedicoprescriviVisitaModify(params.getIdRelazione(), params.getNuovaVisitaMedica(),
                        params.getNuovaCartellaClinica(), params.getNuovoMedico()), VisitaPrescrizioneDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(prescriviVisitaModify.getEsito().getMessaggi());
        return prescriviVisitaModify.getPayload();
    }
}
