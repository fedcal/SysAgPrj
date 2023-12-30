package com.bff.service.msenciclopedia;

import com.bff.dto.msenciclopedia.SintomoDto;
import com.bff.dto.msenciclopedia.params.sintomo.SintomoChangeParams;
import com.bff.dto.msenciclopedia.params.sintomo.SintomoInfoParams;
import com.bff.dto.msenciclopedia.params.sintomo.SintomoParams;
import com.bff.enciclopedia.api.SintomoControllerApi;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SintomoService {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private GenericResponseConverter genericResponseConverter;

    @Autowired
    private SintomoControllerApi sintomoControllerApi;

    public List<SintomoDto> getAll() {
        GenericResponseDto<List<SintomoDto>> listaSintomi = genericResponseConverter.convertGenericResponseList(
                sintomoControllerApi.getAll(),SintomoDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(listaSintomi.getEsito().getMessaggi());
        return listaSintomi.getPayload();
    }

    public SintomoDto addSintomo(SintomoParams params) {
        GenericResponseDto<SintomoDto> addSintomo = genericResponseConverter.convertGenericResponse(
                sintomoControllerApi.addSintomo(params.getNomeSintomo(), params.getDescrizioneSintomo()),SintomoDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(addSintomo.getEsito().getMessaggi());
        return addSintomo.getPayload();
    }

    public SintomoDto getInfo(SintomoInfoParams params) {
        GenericResponseDto<SintomoDto> getInfo = genericResponseConverter.convertGenericResponse(
                sintomoControllerApi.getInfoSintomo(params.getIdSintomo(),params.getNomeSintomo()),SintomoDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(getInfo.getEsito().getMessaggi());
        return getInfo.getPayload();
    }

    public String deleteSintomo(SintomoInfoParams params) {
        GenericResponseDto<String> getInfo = genericResponseConverter.convertGenericResponse(
                sintomoControllerApi.deleteSintomo(params.getIdSintomo(),params.getNomeSintomo()),String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(getInfo.getEsito().getMessaggi());
        return getInfo.getPayload();
    }

    public SintomoDto changeSintomo(SintomoChangeParams params) {
        GenericResponseDto<SintomoDto> getInfo = genericResponseConverter.convertGenericResponse(
                sintomoControllerApi.changeSintomo(params.getIdSintomo(), params.getNomeSintomo(), params.getDescrizioneNuova(),
                params.getNomeSintomoNuovo()),SintomoDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(getInfo.getEsito().getMessaggi());
        return getInfo.getPayload();
    }
}
