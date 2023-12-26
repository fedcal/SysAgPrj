package com.msinfo.service;

import com.msinfo.dto.InfermiereDto;
import com.msinfo.dto.params.infermieri.FindInfermiereParams;
import com.msinfo.entity.infermieri.Infermiere;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.Messaggio;
import com.msinfo.esito.constants.EsitoOperazioneEnum;
import com.msinfo.esito.constants.SeveritaMessaggioEnum;
import com.msinfo.exception.EsitoRuntimeException;
import com.msinfo.mapper.infermieri.InfermiereDtoMapper;
import com.msinfo.repository.InfermiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InfermieriService {

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private InfermiereRepository infermiereRepository;
    public List<InfermiereDto> findAll() {
        List<InfermiereDto> catchAll = InfermiereDtoMapper.INSTANCE.toDto(infermiereRepository.findAll());
        if(catchAll.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna lista di infermieri trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findAll");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return catchAll;
        }
    }

    public List<InfermiereDto> findInfermiere(FindInfermiereParams params) {
        checkParams(params);

        List<InfermiereDto> findInfermiereList = new ArrayList<>();

        if(params.getIdInfermiere()!=null){
            Optional<Infermiere> infermiereFind = infermiereRepository.findById(params.getIdInfermiere());
            if (infermiereFind.isPresent()){
                findInfermiereList.add(InfermiereDtoMapper.INSTANCE.toDto(infermiereFind.get()));
            }
        } else if (params.getNomeInfermiere()!=null && params.getCognomeInfermiere()!= null) {
            findInfermiereList.addAll(InfermiereDtoMapper.INSTANCE.toDto(infermiereRepository.findByNomeAndCognome(params.getNomeInfermiere(),params.getCognomeInfermiere())));
        } else if (params.getNomeInfermiere()!=null) {
            findInfermiereList.addAll(InfermiereDtoMapper.INSTANCE.toDto(infermiereRepository.findByNome(params.getNomeInfermiere())));
        } else if (params.getCognomeInfermiere() != null) {
            findInfermiereList.addAll(InfermiereDtoMapper.INSTANCE.toDto(infermiereRepository.findByCognome(params.getCognomeInfermiere())));
        }

        if(!findInfermiereList.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return findInfermiereList;
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findInfermiere");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    private void checkParams(FindInfermiereParams params) {
        if(params.getIdInfermiere() == null && params.getCognomeInfermiere() == null && params.getNomeInfermiere() == null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findInfermiere");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public String deleteInfermiere(Integer id) {
        if (infermiereRepository.findById(id).isPresent()){
            try{
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
                infermiereRepository.deleteById(id);
                return "Infermiere eliminato";
            }catch (Exception e){
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("L'infermiere non è stato eliminato.").build());
                esitoMessaggiRequestContextHolder.setOperationId("deleteInfermiere");
                throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
            }
        }else {
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Infermiere non trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("deleteInfermiere");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
    }
}
