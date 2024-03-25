package com.bff.service.msinfermiere;

import com.bff.dto.msinfermiere.params.MessaggioParamsDto;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.bff.msinfermiere.api.MsInfermieriMessaggisticaControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessaggisticaInfermiereService {

    @Autowired
    private GenericResponseConverter genericResponseConverter;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private MsInfermieriMessaggisticaControllerApi infermieriMessaggisticaControllerApi;

    public String invioMessaggioMedico(MessaggioParamsDto messaggioDto) {
        GenericResponseDto<String> messaggioMedico = genericResponseConverter.convertGenericResponse(
                infermieriMessaggisticaControllerApi.msInfermiereInvioMessaggioMedico(messaggioDto.getMessaggio(),
                        messaggioDto.getLivelloUrgenza()), String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(messaggioMedico.getEsito().getMessaggi());
        return messaggioMedico.getPayload();
    }

    public String invioMessaggioPaziente(MessaggioParamsDto messaggioParamsDto) {
        GenericResponseDto<String> messaggioPaziente = genericResponseConverter.convertGenericResponse(
                infermieriMessaggisticaControllerApi.msInfermiereInvioMessaggioPaziente(messaggioParamsDto.getMessaggio(),
                        messaggioParamsDto.getLivelloUrgenza()), String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(messaggioPaziente.getEsito().getMessaggi());
        return messaggioPaziente.getPayload();
    }
}
