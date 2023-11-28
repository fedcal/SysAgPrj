package com.bff.service;

import com.bff.dto.enciclopedia.MalattiaDto;
import com.bff.enciclopedia.api.MalattiaControllerApi;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnciclopediaService {
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
}
