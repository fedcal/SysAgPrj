package com.bff.service.msinfo;

import com.bff.dto.msinfo.InfermiereDto;
import com.bff.dto.msinfo.params.infermieri.AddInfermiereParams;
import com.bff.dto.msinfo.params.infermieri.FindInfermiereParams;
import com.bff.dto.msinfo.params.infermieri.ModifyInfermiereParams;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.bff.info.api.InfermieriControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfermieriService {
    @Autowired
    private InfermieriControllerApi infermieriControllerApi;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private GenericResponseConverter genericResponseConverter;

    public List<InfermiereDto> findAll() {
        GenericResponseDto<List<InfermiereDto>> listaInfermieri = genericResponseConverter.convertGenericResponseList(
                infermieriControllerApi.getAllInfermiere(), InfermiereDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(listaInfermieri.getEsito().getMessaggi());
        return listaInfermieri.getPayload();
    }

    public List<InfermiereDto> findInfermiere(FindInfermiereParams params) {
        GenericResponseDto<List<InfermiereDto>> listaInfermieri = genericResponseConverter.convertGenericResponseList(
                infermieriControllerApi.findInfermiere(params.getIdInfermiere(), params.getNomeInfermiere(), params.getCognomeInfermiere()), InfermiereDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(listaInfermieri.getEsito().getMessaggi());
        return listaInfermieri.getPayload();
    }

    public String deleteInfermiere(Integer id) {
        GenericResponseDto<String> deleteInfermiere = genericResponseConverter.convertGenericResponse(
                infermieriControllerApi.deleteInfermiere(id), String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(deleteInfermiere.getEsito().getMessaggi());
        return deleteInfermiere.getPayload();
    }

    public InfermiereDto modifyInfermiere(ModifyInfermiereParams params) {
        GenericResponseDto<InfermiereDto> modifyInfermiere = genericResponseConverter.convertGenericResponse(
                infermieriControllerApi.modifyInfermiere(params.getIdInfermiere(), params.getNuovoNome(), params.getNuovoCognome(),
                        params.getNuovoTurno(), params.getNuovoProfilo()), InfermiereDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(modifyInfermiere.getEsito().getMessaggi());
        return modifyInfermiere.getPayload();
    }

    public InfermiereDto addInfermiere(AddInfermiereParams params) {
        GenericResponseDto<InfermiereDto> modifyInfermiere = genericResponseConverter.convertGenericResponse(
                infermieriControllerApi.addInfermiere(params.getNome(), params.getCognome(), params.getTurno(), params.getProfilo()), InfermiereDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(modifyInfermiere.getEsito().getMessaggi());
        return modifyInfermiere.getPayload();
    }
}
