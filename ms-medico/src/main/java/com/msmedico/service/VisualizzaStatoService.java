package com.msmedico.service;

import com.msmedico.dto.params.visualizzastato.FindStatoVisitaMedicaParams;
import com.msmedico.dto.relationentities.VisitaMedicaCartellaDto;
import com.msmedico.entity.relationentities.VisitaMedicaCartella;
import com.msmedico.esito.EsitoMessaggiRequestContextHolder;
import com.msmedico.esito.Messaggio;
import com.msmedico.esito.constants.EsitoOperazioneEnum;
import com.msmedico.esito.constants.SeveritaMessaggioEnum;
import com.msmedico.exception.EsitoRuntimeException;
import com.msmedico.mapper.relationentities.visitamedicacartella.VisitaMedicaCartellaDtoMapper;
import com.msmedico.repository.relationentities.VisitaMedicaCartellaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VisualizzaStatoService {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private VisitaMedicaCartellaRepository visitaMedicaCartellaRepository;

    public List<VisitaMedicaCartellaDto> statoVisita(FindStatoVisitaMedicaParams params) {
        checkParams(params);
        Optional<VisitaMedicaCartella> visitaMedicaCartellaFindId = null;

        List<VisitaMedicaCartella> visitaMedicaCartellaFindList = new ArrayList<>();
        List<VisitaMedicaCartellaDto> visitaMedicaCartellaReturn = new ArrayList<>();

        if(params.getIdCartella()!=null && params.getIdVisitaMedica()!=null){
            visitaMedicaCartellaFindList = visitaMedicaCartellaRepository.findByIdCartellaAndIdVisitaMedica(params.getIdCartella(),
                    params.getIdVisitaMedica());
        }
        if(params.getIdRelazione()!=null){
            visitaMedicaCartellaFindId = visitaMedicaCartellaRepository.findById(params.getIdRelazione());
        }
        if(params.getIdVisitaMedica()!=null){
            visitaMedicaCartellaFindList = visitaMedicaCartellaRepository.findByIdVisitaMedica(params.getIdVisitaMedica());
        }
        if(params.getIdCartella()!=null){
            visitaMedicaCartellaFindList = visitaMedicaCartellaRepository.findByIdCartella(params.getIdCartella());
        }
        if(params.getIdReferto()!=null){
            visitaMedicaCartellaFindList = visitaMedicaCartellaRepository.findByIdReferto(params.getIdReferto());
        }

        if(visitaMedicaCartellaFindId!=null && !visitaMedicaCartellaFindId.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun elemento trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("statoVisita");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
        if(visitaMedicaCartellaFindId!=null && visitaMedicaCartellaFindId.isPresent()){
            visitaMedicaCartellaReturn.add(VisitaMedicaCartellaDtoMapper.INSTANCE.toDto(visitaMedicaCartellaFindId.get()));
        }
        if (!visitaMedicaCartellaFindList.isEmpty()) {
            visitaMedicaCartellaReturn.addAll(VisitaMedicaCartellaDtoMapper.INSTANCE.toDto(visitaMedicaCartellaFindList));
        } else {
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun elemento trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("statoVisita");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
        return visitaMedicaCartellaReturn;
    }

    private void checkParams(FindStatoVisitaMedicaParams params) {
        if(params.getIdCartella()==null && params.getIdRelazione()==null && params.getIdReferto() == null && params.getIdVisitaMedica()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("statoVisita");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }
}
