package com.bff.service.msenciclopedia;

import com.bff.dto.msenciclopedia.MalattiaDto;
import com.bff.dto.msenciclopedia.params.malattia.MalattiaChangeInfoParams;
import com.bff.dto.msenciclopedia.params.malattia.MalattiaInfoParams;
import com.bff.dto.msenciclopedia.params.malattia.MalattiaParams;
import com.bff.enciclopedia.api.MalattiaControllerApi;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MalattieService {
    @Autowired
    private MalattiaControllerApi malattiaControllerApi;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private GenericResponseConverter genericResponseConverter;
    public List<MalattiaDto> findAllMalattie() {
        GenericResponseDto<List<MalattiaDto>> listaMalattie = genericResponseConverter.convertGenericResponseList(malattiaControllerApi.getAllMalattie(),MalattiaDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(listaMalattie.getEsito().getMessaggi());
        return listaMalattie.getPayload();
    }

    public MalattiaDto findMalattiaInfo(MalattiaInfoParams params) {
        GenericResponseDto<MalattiaDto> malattiaDto = genericResponseConverter.convertGenericResponse(
                malattiaControllerApi.getMalattiaInfo(params.getIdMalattia(), params.getNomeMalattia()),MalattiaDto.class);

        esitoMessaggiRequestContextHolder.getMessaggi().addAll(malattiaDto.getEsito().getMessaggi());
        return malattiaDto.getPayload();
    }

    public MalattiaDto addMalattia(MalattiaParams params) {
        GenericResponseDto<MalattiaDto> malattiaDto = genericResponseConverter.convertGenericResponse(
                malattiaControllerApi.addMalattia(params.getNome(), params.getDescrizione()),MalattiaDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(malattiaDto.getEsito().getMessaggi());
        return malattiaDto.getPayload();
    }

    public MalattiaDto changeInfoMalattia(MalattiaChangeInfoParams params) {
        GenericResponseDto<MalattiaDto> malattiaDto = genericResponseConverter.convertGenericResponse(
                malattiaControllerApi.changeInfoMalattia(params.getNome(), params.getId(), params.getNuovoNome(), params.getNuovaDescrizione()),MalattiaDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(malattiaDto.getEsito().getMessaggi());
        return malattiaDto.getPayload();
    }

    public String deleteMalattia(MalattiaInfoParams params) {
        GenericResponseDto<String> malattiaString = genericResponseConverter.convertGenericResponse(
                malattiaControllerApi.deleteMalattia(params.getIdMalattia(), params.getNomeMalattia()),String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(malattiaString.getEsito().getMessaggi());
        return malattiaString.getPayload();
    }
}
