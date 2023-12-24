package com.msinfo.service;

import com.msinfo.dto.ProfiloDto;
import com.msinfo.dto.params.profilo.ProfiloAggiornamentoParams;
import com.msinfo.dto.params.profilo.ProfiloAggiuntaParams;
import com.msinfo.entity.account.Profilo;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.Messaggio;
import com.msinfo.esito.constants.EsitoOperazioneEnum;
import com.msinfo.esito.constants.SeveritaMessaggioEnum;
import com.msinfo.exception.EsitoRuntimeException;
import com.msinfo.mapper.account.profilo.ProfiloDtoMapper;
import com.msinfo.mapper.account.profilo.ProfiloEntityMapper;
import com.msinfo.repository.ProfiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfiloService {
    @Autowired
    private ProfiloRepository profiloRepository;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    public List<ProfiloDto> getAll(){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.INFO)
                .codMsg("Elenco profili.").build());
        esitoMessaggiRequestContextHolder.setOperationId("getAll");
        return ProfiloDtoMapper.INSTANCE.toDto(profiloRepository.findAll());
    }

    public ProfiloDto getInfo(Integer id) {

        if( id == null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.INFO)
                    .codMsg("Inserire un id.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getInfo");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<Profilo> profiloSearch = profiloRepository.findById(id);
        if(profiloSearch.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.INFO)
                    .codMsg("Info profilo.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getInfo");
            return ProfiloDtoMapper.INSTANCE.toDto(profiloSearch.get());
        }else {
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.WARNING)
                    .codMsg("Profilo non presente.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getInfo");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
    }

    public ProfiloDto aggiuntaProfilo(ProfiloAggiuntaParams params) {
        checkProfiloExists(params.getTipo(), null);

        ProfiloDto profiloAdd = new ProfiloDto();
        profiloAdd.setTipo(params.getTipo());
        profiloAdd.setDescrizione(params.getDescrizione());
        profiloAdd.setIdProfilo(profiloRepository.findAll().size()+1);

        return ProfiloDtoMapper.INSTANCE.toDto(profiloRepository.save(ProfiloEntityMapper.INSTANCE.toEntity(profiloAdd)));
    }

    private ProfiloDto checkProfiloExists(String tipo, Integer id) {
        Optional<Profilo> findProfilo;
        if(tipo!=null){
            findProfilo = profiloRepository.findByTipo(tipo);
        }else {
            findProfilo = profiloRepository.findById(id);
        }

        if(findProfilo.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.WARNING)
                    .codMsg("Profilo già presente.").build());
            esitoMessaggiRequestContextHolder.setOperationId("aggiuntaProfilo");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }else{
            return ProfiloDtoMapper.INSTANCE.toDto(findProfilo.get());
        }
    }

    public ProfiloDto modifcaProfilo(ProfiloAggiornamentoParams params) {
        ProfiloDto profiloModificato = checkProfiloExists(null,params.getIdProfilo());
        if(params.getNuovoTipo()!=null){
            profiloModificato.setTipo(params.getNuovoTipo());
        }
        if(params.getNuovaDescrizione()!=null){
            profiloModificato.setDescrizione(params.getNuovaDescrizione());
        }
        return ProfiloDtoMapper.INSTANCE.toDto(profiloRepository.save(ProfiloEntityMapper.INSTANCE.toEntity(profiloModificato)));
    }
}
