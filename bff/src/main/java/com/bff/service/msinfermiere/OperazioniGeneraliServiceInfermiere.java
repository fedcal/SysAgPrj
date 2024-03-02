package com.bff.service.msinfermiere;

import com.bff.dto.msinfermiere.InfermiereDto;
import com.bff.dto.msinfermiere.params.operazionigenerali.*;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.bff.msinfermiere.api.MsInfermieriOperazioniGeneraliControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperazioniGeneraliServiceInfermiere {
    @Autowired
    private GenericResponseConverter genericResponseConverter;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private MsInfermieriOperazioniGeneraliControllerApi operazioniGeneraliControllerApi;


    public List<InfermiereDto> getAll() {
        GenericResponseDto<List<InfermiereDto>> getAllInfermieri = genericResponseConverter.convertGenericResponseList(
                operazioniGeneraliControllerApi.msInfermiereGetAll(), InfermiereDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(getAllInfermieri.getEsito().getMessaggi());
        return getAllInfermieri.getPayload();
    }

    public List<InfermiereDto> getInfermiereInfo(InfermiereInfoParams params) {
        GenericResponseDto<List<InfermiereDto>> infermiereInfo = genericResponseConverter.convertGenericResponseList(
                operazioniGeneraliControllerApi.msInfermiereInformazioniInfermiere(params.getId(), params.getNomeInfermiere(),
                        params.getCognomeInfermiere()),
                InfermiereDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(infermiereInfo.getEsito().getMessaggi());
        return infermiereInfo.getPayload();
    }

    public InfermiereDto addInfermiere(InfermiereAddParams params) {
        GenericResponseDto<InfermiereDto> infermiere = genericResponseConverter.convertGenericResponse(
                operazioniGeneraliControllerApi.msInfermiereAddInfermiere(params.getNome(), params.getCognome(), params.getTurno()),
                InfermiereDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(infermiere.getEsito().getMessaggi());
        return infermiere.getPayload();
    }

    public String deleteInfermiere(InfermiereDeleteParams params) {
        GenericResponseDto<String> infermiere = genericResponseConverter.convertGenericResponse(
                operazioniGeneraliControllerApi.msInfermiereDeleteInfermiere(params.getId(), params.getNome(), params.getCognome()),
                String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(infermiere.getEsito().getMessaggi());
        return infermiere.getPayload();
    }

    public InfermiereDto modifyInfermiere(InfermiereModifyParams params) {
        GenericResponseDto<InfermiereDto> infermiere = genericResponseConverter.convertGenericResponse(
                operazioniGeneraliControllerApi.msInfermiereModificaInfermiere(params.getIdInfermiere(), params.getNomeRicerca(),
                        params.getCognomeRicerca(), params.getNuovoNome(), params.getNuovoCognome(), params.getNuovoTurno()),
                InfermiereDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(infermiere.getEsito().getMessaggi());
        return infermiere.getPayload();
    }

    public List<InfermiereDto> ricercaInfermiereTramiteTurno(InfermieriTurniParams params) {
        GenericResponseDto<List<InfermiereDto>> infermiere = genericResponseConverter.convertGenericResponseList(
                operazioniGeneraliControllerApi.msInfermiereRicercaTramiteTurni(params.getTurno()),
                InfermiereDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(infermiere.getEsito().getMessaggi());
        return infermiere.getPayload();
    }
}
