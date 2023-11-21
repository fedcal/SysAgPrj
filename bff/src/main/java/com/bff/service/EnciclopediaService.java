package com.bff.service;


import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.enciclopedia.api.MedicinaleControllerApi;
import com.enciclopedia.model.GenericResponseDtoListMedicinaleDto;
import com.enciclopedia.model.MedicinaleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnciclopediaService {
    @Autowired
    private  MedicinaleControllerApi medicinaleControllerApi;
    //private final GenericResponseConverter genericResponseConverter;

    //private final EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;


    public List<MedicinaleDto> getAllMedicinali(){
        GenericResponseDtoListMedicinaleDto genericResponseDtoListMedicinaleDto =  medicinaleControllerApi.getAllMedicinali();

        return genericResponseDtoListMedicinaleDto.getPayload();
    }

}
