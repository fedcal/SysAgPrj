package com.msmedico.service;

import com.msmedico.dto.params.messaggistica.MessaggioParamsDto;
import com.msmedico.esito.EsitoMessaggiRequestContextHolder;
import com.msmedico.esito.GenericResponseConverter;
import com.msmedico.esito.GenericResponseDto;
import com.msmedico.esito.Messaggio;
import com.msmedico.esito.constants.EsitoOperazioneEnum;
import com.msmedico.esito.constants.SeveritaMessaggioEnum;
import com.msmedico.exception.EsitoRuntimeException;
import com.msmedico.msinfermiere.api.MsInfermieriMessaggisticaControllerApi;
import com.msmedico.mspaziente.api.MsPazientiMessaggisticaControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MessaggisticaService {
    @Autowired
    private GenericResponseConverter genericResponseConverter;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
    @Autowired
    private MsInfermieriMessaggisticaControllerApi messaggisticaControllerApiInfermiere;
    @Autowired
    private MsPazientiMessaggisticaControllerApi pazientiMessaggisticaControllerApi;
    public String invioMessaggioInfermiere(MessaggioParamsDto messaggioDto) {
        GenericResponseDto<String> invioMessaggio = genericResponseConverter.convertGenericResponse(
                messaggisticaControllerApiInfermiere.msInfermiereRiceviMessaggioMedico(messaggioDto.getMessaggio(),messaggioDto.getLivelloUrgenza()),String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(invioMessaggio.getEsito().getMessaggi());
        esitoMessaggiRequestContextHolder.setCodRet(invioMessaggio.getEsito().getCodRet());
        esitoMessaggiRequestContextHolder.setOperationId(invioMessaggio.getEsito().getOperationId());
        return invioMessaggio.getPayload();
    }

    public String riceviMessaggioInfermiere(MessaggioParamsDto messaggioDto) {
        if(messaggioDto.getLivelloUrgenza()==null || messaggioDto.getLivelloUrgenza().isBlank()){
            System.out.println("\n***********\n"+"MESSAGGIO SENZA URGENZA DAL REPARTO MEDICO : "+messaggioDto.getMessaggio()+"\n***********\n");
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return "Messaggio ricevuto";
        }
        if(messaggioDto.getLivelloUrgenza().equalsIgnoreCase("LOW")){
            System.out.println("\n***********\n"+"LOW MESSAGGIO DAL REPARTO MEDICO : "+messaggioDto.getMessaggio()+"\n***********\n");
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return "Messaggio ricevuto";
        } else if (messaggioDto.getLivelloUrgenza().equalsIgnoreCase("HIGH")) {
            System.out.println("\n***********\n"+"MESSAGGIO PRIORITARIO DAL REPARTO MEDICO : "+messaggioDto.getMessaggio()+"\n***********\n");
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return "Messaggio ricevuto";
        }else if (messaggioDto.getLivelloUrgenza().equalsIgnoreCase("MEDIUM")) {
            System.out.println("\n***********\n"+"MESSAGGIO MEDIO DAL REPARTO MEDICO : "+messaggioDto.getMessaggio()+"\n***********\n");
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return "Messaggio ricevuto";
        }
        return "";
    }

    public String invioMessaggioPaziente(MessaggioParamsDto messaggioDto) {
        GenericResponseDto<String> invioMessaggio = genericResponseConverter.convertGenericResponse(
                pazientiMessaggisticaControllerApi.msPazienteRiceviMessaggioMedico(messaggioDto.getMessaggio(),messaggioDto.getLivelloUrgenza()),String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(invioMessaggio.getEsito().getMessaggi());
        esitoMessaggiRequestContextHolder.setCodRet(invioMessaggio.getEsito().getCodRet());
        esitoMessaggiRequestContextHolder.setOperationId(invioMessaggio.getEsito().getOperationId());
        return invioMessaggio.getPayload();
    }

    public String riceviMessaggioPaziente(MessaggioParamsDto messaggioDto) {
        if(messaggioDto.getLivelloUrgenza()==null || messaggioDto.getLivelloUrgenza().isBlank()){
            System.out.println("\n***********\n"+"MESSAGGIO SENZA URGENZA DAL REPARTO MEDICO : "+messaggioDto.getMessaggio()+"\n***********\n");
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return "Messaggio ricevuto";
        }
        if(messaggioDto.getLivelloUrgenza().equalsIgnoreCase("LOW")){
            System.out.println("\n***********\n"+"LOW MESSAGGIO DAL REPARTO MEDICO : "+messaggioDto.getMessaggio()+"\n***********\n");
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return "Messaggio ricevuto";
        } else if (messaggioDto.getLivelloUrgenza().equalsIgnoreCase("HIGH")) {
            System.out.println("\n***********\n"+"MESSAGGIO PRIORITARIO DAL REPARTO MEDICO : "+messaggioDto.getMessaggio()+"\n***********\n");
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return "Messaggio ricevuto";
        }else if (messaggioDto.getLivelloUrgenza().equalsIgnoreCase("MEDIUM")) {
            System.out.println("\n***********\n"+"MESSAGGIO MEDIO DAL REPARTO MEDICO : "+messaggioDto.getMessaggio()+"\n***********\n");
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return "Messaggio ricevuto";
        }
        return "";
    }
}
