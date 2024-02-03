package com.bff.service.msmedico;

import com.bff.dto.msmedico.params.messaggistica.MessaggioParamsDto;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.bff.msmedico.api.MediciMessaggisticaControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessaggisticaService {
    @Autowired
    private GenericResponseConverter genericResponseConverter;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
    @Autowired
    private MediciMessaggisticaControllerApi messaggisticaControllerApi;
    public String invioMessaggioInfermiere(MessaggioParamsDto messaggioDto) {
        GenericResponseDto<String> listaMedici = genericResponseConverter.convertGenericResponse(
                messaggisticaControllerApi.msMedicoInvioMessaggioInfermiere(messaggioDto.getMessaggio(),messaggioDto.getLivelloUrgenza()), String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(listaMedici.getEsito().getMessaggi());
        return listaMedici.getPayload();
    }


    public String invioMessaggioPaziente(MessaggioParamsDto messaggioParamsDto) {
        GenericResponseDto<String> listaMedici = genericResponseConverter.convertGenericResponse(
                messaggisticaControllerApi.msMedicoInvioMessaggioPaziente(messaggioParamsDto.getMessaggio(),messaggioParamsDto.getLivelloUrgenza()), String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(listaMedici.getEsito().getMessaggi());
        return listaMedici.getPayload();
    }
}
