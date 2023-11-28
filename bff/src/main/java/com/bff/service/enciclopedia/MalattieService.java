package com.bff.service.enciclopedia;

import com.bff.dto.enciclopedia.MalattiaDto;
import com.bff.dto.enciclopedia.params.malattia.MalattiaChangeInfoParams;
import com.bff.dto.enciclopedia.params.malattia.MalattiaInfoParams;
import com.bff.dto.enciclopedia.params.malattia.MalattiaParams;
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
        com.bff.enciclopedia.model.MalattiaInfoParams malattiaInfoParams = new com.bff.enciclopedia.model.MalattiaInfoParams();
        malattiaInfoParams.setIdMalattia(params.getIdMalattia());
        malattiaInfoParams.setNomeMalattia(params.getNomeMalattia());

        GenericResponseDto<MalattiaDto> malattiaDto = genericResponseConverter.convertGenericResponse(malattiaControllerApi.getMalattiaInfo(malattiaInfoParams),MalattiaDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(malattiaDto.getEsito().getMessaggi());
        return malattiaDto.getPayload();
    }

    public MalattiaDto addMalattia(MalattiaParams params) {
        com.bff.enciclopedia.model.MalattiaParams malattiaAddParams = new com.bff.enciclopedia.model.MalattiaParams();
        malattiaAddParams.setDescrizione(params.getDescrizione());
        malattiaAddParams.setNome(params.getNome());

        GenericResponseDto<MalattiaDto> malattiaDto = genericResponseConverter.convertGenericResponse(malattiaControllerApi.addMalattia(malattiaAddParams),MalattiaDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(malattiaDto.getEsito().getMessaggi());
        return malattiaDto.getPayload();
    }

    public MalattiaDto changeInfoMalattia(MalattiaChangeInfoParams params) {
        com.bff.enciclopedia.model.MalattiaChangeInfoParams malattiaChangeParams = new com.bff.enciclopedia.model.MalattiaChangeInfoParams();
        malattiaChangeParams.setNome(params.getNome());
        malattiaChangeParams.setId(params.getId());
        malattiaChangeParams.setNuovaDescrizione(params.getNuovaDescrizione());
        malattiaChangeParams.setNuovoNome(params.getNuovoNome());

        GenericResponseDto<MalattiaDto> malattiaDto = genericResponseConverter.convertGenericResponse(malattiaControllerApi.changeInfoMalattia(malattiaChangeParams),MalattiaDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(malattiaDto.getEsito().getMessaggi());
        return malattiaDto.getPayload();
    }

    public String deleteMalattia(MalattiaInfoParams params) {
        com.bff.enciclopedia.model.MalattiaInfoParams deleteParams = new com.bff.enciclopedia.model.MalattiaInfoParams();
        deleteParams.setNomeMalattia(params.getNomeMalattia());
        deleteParams.setIdMalattia(params.getIdMalattia());

        GenericResponseDto<String> malattiaString = genericResponseConverter.convertGenericResponse(malattiaControllerApi.deleteMalattia(deleteParams),String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(malattiaString.getEsito().getMessaggi());
        return malattiaString.getPayload();
    }
}
