package com.bff.service.msenciclopedia;

import com.bff.dto.msenciclopedia.SintomoMalattiaDto;
import com.bff.dto.msenciclopedia.params.sintomomalattia.SintomoMalattiaChangeParams;
import com.bff.dto.msenciclopedia.params.sintomomalattia.SintomoMalattiaParams;
import com.bff.enciclopedia.api.SintomoMalattiaControllerApi;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SintomoMalattiaService {

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private GenericResponseConverter genericResponseConverter;

    @Autowired
    private SintomoMalattiaControllerApi sintomoMalattiaControllerApi;

    public List<SintomoMalattiaDto> getAll() {
        GenericResponseDto<List<SintomoMalattiaDto>> listaSintomi = genericResponseConverter.convertGenericResponseList(
                sintomoMalattiaControllerApi.getAllSintomoMalattia(),SintomoMalattiaDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(listaSintomi.getEsito().getMessaggi());
        return listaSintomi.getPayload();
    }

    public SintomoMalattiaDto addSintomo(SintomoMalattiaParams params) {
        GenericResponseDto<SintomoMalattiaDto> addSintomo = genericResponseConverter.convertGenericResponse(
                sintomoMalattiaControllerApi.addSintomoMalattia(params.getIdSintomo(), params.getIdMalattia()),SintomoMalattiaDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(addSintomo.getEsito().getMessaggi());
        return addSintomo.getPayload();
    }

    public SintomoMalattiaDto infoSintomo(SintomoMalattiaParams params) {
        GenericResponseDto<SintomoMalattiaDto> infoSintomo = genericResponseConverter.convertGenericResponse(
                sintomoMalattiaControllerApi.infoSintomoMalattia(params.getIdSintomo(), params.getIdMalattia()),SintomoMalattiaDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(infoSintomo.getEsito().getMessaggi());
        return infoSintomo.getPayload();
    }

    public String deleteSintomoRelation(SintomoMalattiaParams params) {
        GenericResponseDto<String> infoSintomo = genericResponseConverter.convertGenericResponse(
                sintomoMalattiaControllerApi.deleteSintomoMalattia(params.getIdSintomo(), params.getIdMalattia()),String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(infoSintomo.getEsito().getMessaggi());
        return infoSintomo.getPayload();
    }

    public SintomoMalattiaDto modifySintomo(SintomoMalattiaChangeParams params) {
        GenericResponseDto<SintomoMalattiaDto> infoSintomo = genericResponseConverter.convertGenericResponse(
                sintomoMalattiaControllerApi.modifySintomoMalattia(params.getIdRelazione(), params.getIdMalattia(),
                        params.getIdSintomo(), params.getNewIdMalattia(), params.getNewIdSitnomo()),SintomoMalattiaDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(infoSintomo.getEsito().getMessaggi());
        return infoSintomo.getPayload();
    }
}
