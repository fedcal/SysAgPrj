package com.bff.service.msmedico;

import com.bff.dto.msmedico.params.visualizzastato.FindCartellaClinicaParams;
import com.bff.dto.msmedico.params.visualizzastato.FindOperazioneParams;
import com.bff.dto.msmedico.params.visualizzastato.FindStatoVisitaMedicaParams;
import com.bff.dto.msmedico.paziente.CartellaClinicaDto;
import com.bff.dto.msmedico.relationentities.OperazioneCartellaDto;
import com.bff.dto.msmedico.relationentities.VisitaMedicaCartellaDto;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseConverter;
import com.bff.esito.GenericResponseDto;
import com.bff.msmedico.api.VisualizzaStatoControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisualizzaStatoService {
    @Autowired
    private GenericResponseConverter genericResponseConverter;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
    @Autowired
    private VisualizzaStatoControllerApi visualizzaStatoControllerApi;
    public List<VisitaMedicaCartellaDto> statoVisita(FindStatoVisitaMedicaParams params) {
        GenericResponseDto<List<VisitaMedicaCartellaDto>> statoVisita = genericResponseConverter.convertGenericResponseList(
                visualizzaStatoControllerApi.msMedicoGetStatoVisita(params.getIdRelazione(), params.getIdCartella(),
                        params.getIdVisitaMedica(), params.getIdReferto()), VisitaMedicaCartellaDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(statoVisita.getEsito().getMessaggi());
        return statoVisita.getPayload();
    }

    public List<CartellaClinicaDto> statoCartellaClinica(FindCartellaClinicaParams params) {
        GenericResponseDto<List<CartellaClinicaDto>> statoVisita = genericResponseConverter.convertGenericResponseList(
                visualizzaStatoControllerApi.msMedicoGetCartelleCliniche(params.getIdCartellaClinica(),
                        params.getIdPaziente(), params.getNome(), params.getCognome()), CartellaClinicaDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(statoVisita.getEsito().getMessaggi());
        return statoVisita.getPayload();
    }

    public List<OperazioneCartellaDto> operazioneCartella(FindOperazioneParams params) {
        GenericResponseDto<List<OperazioneCartellaDto>> statoVisita = genericResponseConverter.convertGenericResponseList(
                visualizzaStatoControllerApi.msMedicoGetStatoOperazione(params.getIdRelazione(), params.getIdOperazione(),
                        params.getNomeOperazione(), params.getIdCartellaClinica(), params.getIdPaziente(),
                        params.getNomePaziente(), params.getCognomePaziente(), params.getIdMedico(), params.getNomeMedico(),
                        params.getCognomeMedico(), params.getIdReferto()), OperazioneCartellaDto.class);
        esitoMessaggiRequestContextHolder.getMessaggi().addAll(statoVisita.getEsito().getMessaggi());
        return statoVisita.getPayload();
    }
}
