package com.msinfermiere.service;

import com.msinfermiere.dto.params.messaggimedico.InfermiereMedicoMessaggioDto;
import com.msinfermiere.dto.params.messaggimedico.MedicoInfermiereMessaggioDto;
import com.msinfermiere.esito.EsitoMessaggiRequestContextHolder;
import com.msinfermiere.esito.GenericResponseConverter;
import com.msinfermiere.esito.GenericResponseDto;
import com.msinfermiere.esito.Messaggio;
import com.msinfermiere.esito.constants.EsitoOperazioneEnum;
import com.msinfermiere.esito.constants.SeveritaMessaggioEnum;
import com.msinfermiere.exception.EsitoRuntimeException;
import com.msinfermiere.msmedico.api.MediciMessaggisticaControllerApi;
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
    private MediciMessaggisticaControllerApi mediciMessaggisticaControllerApi;

    public String invioMessaggioMedico(InfermiereMedicoMessaggioDto messaggioDto) {
        GenericResponseDto<String> invioMessaggio = genericResponseConverter.convertGenericResponse(
                mediciMessaggisticaControllerApi.msMedicoRiceviMessaggioInfermiere(messaggioDto.getMessaggio(),messaggioDto.getLivelloUrgenza()),String.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(invioMessaggio.getEsito().getMessaggi());
        esitoMessaggiRequestContextHolder.setCodRet(invioMessaggio.getEsito().getCodRet());
        esitoMessaggiRequestContextHolder.setOperationId(invioMessaggio.getEsito().getOperationId());
        return invioMessaggio.getPayload();
    }

    public String riceviMessaggioMedico(MedicoInfermiereMessaggioDto messaggioDto) {
        if(messaggioDto.getLivelloUrgenza()!=null && (!messaggioDto.getLivelloUrgenza().equalsIgnoreCase("HIGH") &&
                messaggioDto.getLivelloUrgenza().equalsIgnoreCase("MEDIUM")&& messaggioDto.getLivelloUrgenza().equalsIgnoreCase("LOW"))){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Livello di urgenza non corretto.").build());
            esitoMessaggiRequestContextHolder.setOperationId("riceviMessaggioMedico");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
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
