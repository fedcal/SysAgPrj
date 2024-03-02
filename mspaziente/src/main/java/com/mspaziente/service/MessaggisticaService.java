package com.mspaziente.service;

import com.mspaziente.dto.params.MessaggioParamsDto;
import com.mspaziente.esito.EsitoMessaggiRequestContextHolder;
import com.mspaziente.esito.GenericResponseConverter;
import com.mspaziente.esito.GenericResponseDto;
import com.mspaziente.esito.Messaggio;
import com.mspaziente.esito.constants.EsitoOperazioneEnum;
import com.mspaziente.esito.constants.SeveritaMessaggioEnum;
import com.mspaziente.exception.EsitoRuntimeException;
import com.mspaziente.msinfermiere.api.MsInfermieriInfermieriMessaggisticaControllerApi;
import com.mspaziente.msmedico.api.MediciMessaggisticaControllerApi;
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
    private MsInfermieriInfermieriMessaggisticaControllerApi messaggisticaControllerApiInfermiere;
    @Autowired
    private MediciMessaggisticaControllerApi messaggisticaControllerApiMedico;

    public String invioMessaggioMedico(MessaggioParamsDto messaggioParamsDto) {
        GenericResponseDto<String> invioMessaggio = genericResponseConverter.convertGenericResponse(
                messaggisticaControllerApiMedico.msMedicoRiceviMessaggioPaziente(messaggioParamsDto.getMessaggio(),messaggioParamsDto.getLivelloUrgenza()),String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(invioMessaggio.getEsito().getMessaggi());
        esitoMessaggiRequestContextHolder.setCodRet(invioMessaggio.getEsito().getCodRet());
        esitoMessaggiRequestContextHolder.setOperationId(invioMessaggio.getEsito().getOperationId());
        return invioMessaggio.getPayload();
    }

    public String riceviMessaggioMedico(MessaggioParamsDto messaggioParamsDto) {
        if(messaggioParamsDto.getLivelloUrgenza()!=null && (!messaggioParamsDto.getLivelloUrgenza().equalsIgnoreCase("HIGH") ||
                messaggioParamsDto.getLivelloUrgenza().equalsIgnoreCase("MEDIUM")|| messaggioParamsDto.getLivelloUrgenza().equalsIgnoreCase("LOW"))){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Livello di urgenza non corretto.").build());
            esitoMessaggiRequestContextHolder.setOperationId("riceviMessaggioInfermiere");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
        if(messaggioParamsDto.getLivelloUrgenza()==null || messaggioParamsDto.getLivelloUrgenza().isBlank()){
            System.out.println("\n***********\n"+"MESSAGGIO SENZA URGENZA DAL REPARTO MEDICO : "+messaggioParamsDto.getMessaggio()+"\n***********\n");
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return "Messaggio ricevuto";
        }
        if(messaggioParamsDto.getLivelloUrgenza().equalsIgnoreCase("LOW")){
            System.out.println("\n***********\n"+"LOW MESSAGGIO DAL REPARTO MEDICO : "+messaggioParamsDto.getMessaggio()+"\n***********\n");
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return "Messaggio ricevuto";
        } else if (messaggioParamsDto.getLivelloUrgenza().equalsIgnoreCase("HIGH")) {
            System.out.println("\n***********\n"+"MESSAGGIO PRIORITARIO DAL REPARTO MEDICO : "+messaggioParamsDto.getMessaggio()+"\n***********\n");
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return "Messaggio ricevuto";
        }else if (messaggioParamsDto.getLivelloUrgenza().equalsIgnoreCase("MEDIUM")) {
            System.out.println("\n***********\n"+"MESSAGGIO MEDIO DAL REPARTO MEDICO : "+messaggioParamsDto.getMessaggio()+"\n***********\n");
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return "Messaggio ricevuto";
        }
        return "";
    }

    public String riceviMessaggioInfermiere(MessaggioParamsDto messaggioDto) {
        if(messaggioDto.getLivelloUrgenza()!=null && (!messaggioDto.getLivelloUrgenza().equalsIgnoreCase("HIGH") ||
                messaggioDto.getLivelloUrgenza().equalsIgnoreCase("MEDIUM")|| messaggioDto.getLivelloUrgenza().equalsIgnoreCase("LOW"))){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Livello di urgenza non corretto.").build());
            esitoMessaggiRequestContextHolder.setOperationId("riceviMessaggioInfermiere");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
        if(messaggioDto.getLivelloUrgenza()==null || messaggioDto.getLivelloUrgenza().isBlank()){
            System.out.println("\n***********\n"+"MESSAGGIO SENZA URGENZA DAL REPARTO INFERMIERE : "+messaggioDto.getMessaggio()+"\n***********\n");
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return "Messaggio ricevuto";
        }
        if(messaggioDto.getLivelloUrgenza().equalsIgnoreCase("LOW")){
            System.out.println("\n***********\n"+"LOW MESSAGGIO DAL REPARTO INFERMIERE : "+messaggioDto.getMessaggio()+"\n***********\n");
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return "Messaggio ricevuto";
        } else if (messaggioDto.getLivelloUrgenza().equalsIgnoreCase("HIGH")) {
            System.out.println("\n***********\n"+"MESSAGGIO PRIORITARIO DAL REPARTO INFERMIERE : "+messaggioDto.getMessaggio()+"\n***********\n");
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return "Messaggio ricevuto";
        }else if (messaggioDto.getLivelloUrgenza().equalsIgnoreCase("MEDIUM")) {
            System.out.println("\n***********\n"+"MESSAGGIO MEDIO DAL REPARTO INFERMIERE : "+messaggioDto.getMessaggio()+"\n***********\n");
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return "Messaggio ricevuto";
        }
        return "";
    }

    public String invioMessaggioInfermiere(MessaggioParamsDto messaggioDto) {
        GenericResponseDto<String> invioMessaggio = genericResponseConverter.convertGenericResponse(
                messaggisticaControllerApiInfermiere.msInfermiereRiceviMessaggioPaziente(messaggioDto.getMessaggio(),messaggioDto.getLivelloUrgenza()),String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(invioMessaggio.getEsito().getMessaggi());
        esitoMessaggiRequestContextHolder.setCodRet(invioMessaggio.getEsito().getCodRet());
        esitoMessaggiRequestContextHolder.setOperationId(invioMessaggio.getEsito().getOperationId());
        return invioMessaggio.getPayload();
    }
}
