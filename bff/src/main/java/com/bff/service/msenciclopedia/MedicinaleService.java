package com.bff.service.msenciclopedia;


import com.bff.dto.msenciclopedia.MedicinaleDto;
import com.bff.dto.msenciclopedia.params.medicinale.MedicinaleInfoParams;
import com.bff.dto.msenciclopedia.params.medicinale.MedicinaleParams;
import com.bff.enciclopedia.api.MedicinaleControllerApi;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicinaleService {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private GenericResponseConverter genericResponseConverter;

    @Autowired
    private MedicinaleControllerApi medicinaleControllerApi;

    public List<MedicinaleDto> findAllMedicinali() {
        GenericResponseDto<List<MedicinaleDto>> listaMedicinali = genericResponseConverter.convertGenericResponseList(
                medicinaleControllerApi.getAllMedicinali(),MedicinaleDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(listaMedicinali.getEsito().getMessaggi());
        return listaMedicinali.getPayload();
    }

    public MedicinaleDto modificaMedicinale(Integer idMedicinale, MedicinaleParams params) {
        GenericResponseDto<MedicinaleDto> modificaMedicinale = genericResponseConverter.convertGenericResponse(
                medicinaleControllerApi.modificaMedicinale(idMedicinale,params.getNome(),params.getDescrizione(),params.getDosaggio()),
                MedicinaleDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(modificaMedicinale.getEsito().getMessaggi());
        return modificaMedicinale.getPayload();
    }

    public MedicinaleDto addMedicinale(MedicinaleParams params) {
        GenericResponseDto<MedicinaleDto> addMedicinale = genericResponseConverter.convertGenericResponse(
                medicinaleControllerApi.addMedicinale(params.getNome(),params.getDescrizione(),params.getDosaggio()),
                MedicinaleDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(addMedicinale.getEsito().getMessaggi());
        return addMedicinale.getPayload();
    }

    public String deleteMedicinaleId(MedicinaleInfoParams params) {
        GenericResponseDto<String> deleteMedicinaleId = genericResponseConverter.convertGenericResponse(
                medicinaleControllerApi.deleteMedicinaleId(params.getIdMedicinale(),params.getNomeMedicinale()),
                String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(deleteMedicinaleId.getEsito().getMessaggi());
        return deleteMedicinaleId.getPayload();
    }

    public MedicinaleDto findInfoMedicinale(MedicinaleInfoParams params) {
        GenericResponseDto<MedicinaleDto> findInfoMedicinale = genericResponseConverter.convertGenericResponse(
                medicinaleControllerApi.getInfoMedicinale(params.getIdMedicinale(), params.getNomeMedicinale()),
                MedicinaleDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(findInfoMedicinale.getEsito().getMessaggi());
        return findInfoMedicinale.getPayload();
    }
}
