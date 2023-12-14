package com.msinfo.service;

import com.msinfo.dto.PazienteDto;
import com.msinfo.dto.params.paziente.PazienteSearchParams;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.constants.EsitoOperazioneEnum;
import com.msinfo.exception.EsitoRuntimeException;
import com.msinfo.mapper.pazienti.paziente.PazienteDtoMapper;
import com.msinfo.repository.PazienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PazienteService {
    @Autowired
    private PazienteRepository pazienteRepository;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    public List<PazienteDto> findAll(){
        List<PazienteDto> listaPazienti = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findAll());
        if(listaPazienti.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.setOperationId("Non sono stati trovati pazienti all'interno dell'ospedale");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }

        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("Elenco pazienti");
        return PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findAll());
    }

    public List<PazienteDto> searchPaziente(PazienteSearchParams params) {
        List<PazienteDto> pazienteDtoList = null;

        if(params.getNome()!=null && params.getCognome()!=null){
            pazienteDtoList = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findByNomeAndCognome(params.getNome(),params.getCognome()));
        }

        if(params.getIdPaziente()!=null){
            pazienteDtoList = Collections.singletonList(PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findById(params.getIdPaziente()).get()));
        }

        if (params.getNome()!=null){
            pazienteDtoList = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findByNome(params.getNome()));
        }

        if (params.getCognome()!=null){
            pazienteDtoList = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findByCognome(params.getCognome()));
        }

        if(params.getDataNascita()!=null){
            pazienteDtoList = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findByDataNascita(params.getDataNascita()));
        }

        if(params.getContattoRiferimentoDto().getIdContatto()!=null){
            pazienteDtoList = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findByIdContatto(params.getContattoRiferimentoDto().getIdContatto()));
        }

        if(params.getContattoRiferimentoDto().getNome()!=null){
            pazienteDtoList = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findByNomeContatto(params.getContattoRiferimentoDto().getNome()));
        }

        if(params.getContattoRiferimentoDto().getCognome()!=null){
            pazienteDtoList = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findByCognomeContatto(params.getContattoRiferimentoDto().getCognome()));
        }

        if(params.getContattoRiferimentoDto().getNumeroCellulare()!=null){
            pazienteDtoList = PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findByContattoNumeroCellulare(params.getContattoRiferimentoDto().getNumeroCellulare()));
        }

        if (pazienteDtoList == null || pazienteDtoList.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.setOperationId("Non sono stati trovati pazienti corrispondenti ai parametri " +
                    "di ricerca.");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("Lista di pazienti");
            return pazienteDtoList;
        }
    }
}
