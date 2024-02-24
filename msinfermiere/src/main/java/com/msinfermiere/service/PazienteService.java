package com.msinfermiere.service;

import com.msinfermiere.dto.params.PazienteFiltratiParams;
import com.msinfermiere.dto.paziente.PazienteDto;
import com.msinfermiere.entity.paziente.Paziente;
import com.msinfermiere.esito.EsitoMessaggiRequestContextHolder;
import com.msinfermiere.esito.Messaggio;
import com.msinfermiere.esito.constants.EsitoOperazioneEnum;
import com.msinfermiere.esito.constants.SeveritaMessaggioEnum;
import com.msinfermiere.exception.EsitoRuntimeException;
import com.msinfermiere.mapper.paziente.paziente.PazienteDtoMapper;
import com.msinfermiere.repository.paziente.PazienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PazienteService {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private PazienteRepository pazienteRepository;

    public List<PazienteDto> getAllPazienti() {
        List<Paziente> findAll = pazienteRepository.findAll();
        if(findAll.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Lista paziente vuota.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getAllPazienti");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }

        return PazienteDtoMapper.INSTANCE.toDto(findAll);
    }

    public List<PazienteDto> getPazientiFiltrati(PazienteFiltratiParams params) {
        checkParams(params);
        List<Paziente> findListPaziente = new ArrayList<>();
        if(params.getIdPaziente()!=null){
            findListPaziente = Arrays.asList(pazienteRepository.findById(params.getIdPaziente()).get());
        }
        if(StringUtils.hasLength(params.getNome()) && StringUtils.hasLength(params.getCognome())){
            findListPaziente = pazienteRepository.findByNomeAndCognomePaziente(params.getNome(),params.getCognome());
        }
        if(StringUtils.hasLength(params.getNome())){
            findListPaziente = pazienteRepository.findByNomePaziente(params.getNome());
        }
        if(StringUtils.hasLength(params.getCognome())){
            findListPaziente = pazienteRepository.findByCognomePaziente(params.getCognome());
        }
        if(findListPaziente.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun paziente trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getPazientiFiltrati");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            return PazienteDtoMapper.INSTANCE.toDto(findListPaziente);
        }
    }

    private void checkParams(PazienteFiltratiParams params) {
        if(params.getIdPaziente()!=null && !StringUtils.hasLength(params.getNome()) && !StringUtils.hasLength(params.getCognome())){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getPazientiFiltrati");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }
}
