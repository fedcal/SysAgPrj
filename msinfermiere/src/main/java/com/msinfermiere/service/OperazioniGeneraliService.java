package com.msinfermiere.service;

import com.msinfermiere.dto.InfermiereDto;
import com.msinfermiere.dto.params.operazionigenerali.*;
import com.msinfermiere.entity.Infermiere;
import com.msinfermiere.esito.EsitoMessaggiRequestContextHolder;
import com.msinfermiere.esito.Messaggio;
import com.msinfermiere.esito.constants.EsitoOperazioneEnum;
import com.msinfermiere.esito.constants.SeveritaMessaggioEnum;
import com.msinfermiere.exception.EsitoRuntimeException;
import com.msinfermiere.mapper.infermiere.InfermiereDtoMapper;
import com.msinfermiere.repository.InfermiereRepository;
import com.msinfermiere.repository.account.ProfiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class OperazioniGeneraliService {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private InfermiereRepository infermiereRepository;

    @Autowired
    private ProfiloRepository profiloRepository;

    public List<InfermiereDto> getAll() {
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getAll");
        return InfermiereDtoMapper.INSTANCE.toDto(infermiereRepository.findAll());
    }


    public List<InfermiereDto> getInfermiereInfo(InfermiereInfoParams params) {
        checkParams(params);

        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getInfermiereInfo");

        if(StringUtils.hasLength(params.getNomeInfermiere()) && StringUtils.hasLength(params.getCognomeInfermiere())){
            return InfermiereDtoMapper.INSTANCE.toDto(infermiereRepository.findByNomeAndCognome(params.getNomeInfermiere(), params.getCognomeInfermiere()));
        }
        if(StringUtils.hasLength(params.getNomeInfermiere())){
            return InfermiereDtoMapper.INSTANCE.toDto(infermiereRepository.findByNome(params.getNomeInfermiere()));
        }
        if(StringUtils.hasLength(params.getCognomeInfermiere())){
            return InfermiereDtoMapper.INSTANCE.toDto(infermiereRepository.findByNome(params.getCognomeInfermiere()));
        }
        if(params.getId()!=null){
            return Arrays.asList(InfermiereDtoMapper.INSTANCE.toDto(infermiereRepository.findById(Integer.valueOf(params.getId())).get()));
        }
        return new ArrayList<>();
    }

    private void checkParams(InfermiereInfoParams params) {
        if (!StringUtils.hasLength(params.getCognomeInfermiere()) && !StringUtils.hasLength(params.getNomeInfermiere())
                && params.getId()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserisci almeno un parametro.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getFiltrati");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public InfermiereDto addInfermiere(InfermiereAddParams params) {
        Infermiere infermiere = new Infermiere();
        checkParams(params);

        infermiere.setNome(params.getNome());
        infermiere.setCognome(params.getCognome());
        infermiere.setTurno(params.getTurno());
        infermiere.setProfilo(profiloRepository.findById(2).get());

        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("addInfermiere");
        return InfermiereDtoMapper.INSTANCE.toDto(infermiereRepository.save(infermiere));
    }

    private void checkParams(InfermiereAddParams params) {
        if(!StringUtils.hasLength(params.getNome()) && !StringUtils.hasLength(params.getCognome()) &&
           !StringUtils.hasLength(params.getTurno())){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserisci almeno un parametro.").build());
            esitoMessaggiRequestContextHolder.setOperationId("addInfermiere");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public String deleteInfermiere(InfermiereDeleteParams params) {
        checkParams(params);

        Optional<Infermiere> findInfermiere = Optional.empty();

        if(params.getId()!=null){
            findInfermiere = infermiereRepository.findById(params.getId());
        }

        if(StringUtils.hasLength(params.getNome()) && StringUtils.hasLength(params.getCognome())){
            findInfermiere = Optional.of(infermiereRepository.findByNomeAndCognome(params.getNome(), params.getCognome()).get(0));
        }
        if(findInfermiere.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun infermiere trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("deleteInfermiere");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            try{
                infermiereRepository.deleteById(findInfermiere.get().getIdInfermiere());
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
                esitoMessaggiRequestContextHolder.setOperationId("deleteInfermiere");
                return "Infermiere eliminato";
            }catch (IllegalArgumentException  e){
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Impossibile eliminare l'infermiere selezionato.").build());
                esitoMessaggiRequestContextHolder.setOperationId("deleteInfermiere");
                throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
            }
        }
    }

    private void checkParams(InfermiereDeleteParams params) {
        if(params.getId()==null && !StringUtils.hasLength(params.getCognome()) && !StringUtils.hasLength(params.getNome())){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserisci almeno un parametro.").build());
            esitoMessaggiRequestContextHolder.setOperationId("deleteInfermiere");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public InfermiereDto modifyInfermiere(InfermiereModifyParams params) {
        checkParams(params);

        Optional<Infermiere> findInfermiere =  Optional.empty();
        if(params.getIdInfermiere()!=null){
            findInfermiere = infermiereRepository.findById(params.getIdInfermiere());
        }
        if(!StringUtils.hasLength(params.getCognomeRicerca()) && !StringUtils.hasLength(params.getNomeRicerca())){
            findInfermiere = Optional.of(infermiereRepository.findByNomeAndCognome(params.getNomeRicerca(),params.getCognomeRicerca()).get(0));
        }

        if(findInfermiere.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun infermiere trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("modifyInfermiere");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            modifyInfoInfermiere(findInfermiere,params);
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("modifyInfermiere");
            return InfermiereDtoMapper.INSTANCE.toDto(infermiereRepository.save(findInfermiere.get()));
        }
    }

    private void modifyInfoInfermiere(Optional<Infermiere> findInfermiere, InfermiereModifyParams params) {
        if(StringUtils.hasLength(params.getNuovoNome())){
            findInfermiere.get().setNome(params.getNuovoNome());
        }
        if(StringUtils.hasLength(params.getNuovoCognome())){
            findInfermiere.get().setCognome(params.getNuovoCognome());
        }
        if(StringUtils.hasLength(params.getNuovoTurno())){
            findInfermiere.get().setTurno(params.getNuovoTurno());
        }
    }

    private void checkParams(InfermiereModifyParams params) {
        if(params.getIdInfermiere()==null && !StringUtils.hasLength(params.getCognomeRicerca()) && !StringUtils.hasLength(params.getNomeRicerca())){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserisci almeno un parametro di ricerca dell'infermiere da modificare.").build());
            esitoMessaggiRequestContextHolder.setOperationId("modifyInfermiere");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        if(!StringUtils.hasLength(params.getNuovoNome()) && !StringUtils.hasLength(params.getNuovoCognome())
            && !StringUtils.hasLength(params.getNuovoTurno())){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserisci almeno un parametro da modificare.").build());
            esitoMessaggiRequestContextHolder.setOperationId("modifyInfermiere");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public List<InfermiereDto> ricercaInfermiereTramiteTurno(InfermieriTurniParams params) {
        List<Infermiere> findAllInfermieri =  infermiereRepository.findAll();

        if(findAllInfermieri.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Lista infermieri vuota.").build());
            esitoMessaggiRequestContextHolder.setOperationId("ricercaInfermiereTramiteTurno");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            List<Infermiere> infermieriFiltrati = new ArrayList<>();
            for(Infermiere i : findAllInfermieri){
                if(i.getTurno().contains(params.getTurno())){
                    infermieriFiltrati.add(i);
                }
            }
            if(infermieriFiltrati.isEmpty()){
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Nessun infermiere trovato per il turno inserito.").build());
                esitoMessaggiRequestContextHolder.setOperationId("ricercaInfermiereTramiteTurno");
            }else{
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
                esitoMessaggiRequestContextHolder.setOperationId("modifyInfermiere");
                return InfermiereDtoMapper.INSTANCE.toDto(infermieriFiltrati);
            }
        }
        return new ArrayList<>();
    }
}
