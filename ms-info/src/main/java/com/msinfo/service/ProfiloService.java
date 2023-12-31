package com.msinfo.service;

import com.msinfo.dto.ProfiloDto;
import com.msinfo.dto.params.profilo.ModifyProfiloParams;
import com.msinfo.dto.params.profilo.AddProfiloParams;
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
        List<Profilo> listaProfilo = profiloRepository.findAll();

        if(listaProfilo.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.WARNING)
                    .codMsg("Lista profili non trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getAll");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return ProfiloDtoMapper.INSTANCE.toDto(listaProfilo);
        }
    }

    public ProfiloDto getInfo(Integer id) {
        if( id == null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.WARNING)
                    .codMsg("Inserire un id.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getInfo");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<Profilo> profiloSearch = profiloRepository.findById(id);
        if(profiloSearch.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return ProfiloDtoMapper.INSTANCE.toDto(profiloSearch.get());
        }else {
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.WARNING)
                    .codMsg("Profilo non presente.").build());
            esitoMessaggiRequestContextHolder.setOperationId("getInfo");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
    }

    public ProfiloDto aggiuntaProfilo(AddProfiloParams params) {
        checkProfiloExists(params.getTipo(), null);

        ProfiloDto profiloAdd = new ProfiloDto();
        profiloAdd.setTipo(params.getTipo());
        profiloAdd.setDescrizione(params.getDescrizione());

        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
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

    public ProfiloDto modifcaProfilo(ModifyProfiloParams params) {
        if(params.getIdProfilo()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.WARNING)
                    .codMsg("Inserire id del profilo da modificare.").build());
            esitoMessaggiRequestContextHolder.setOperationId("modifcaProfilo");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
        ProfiloDto profiloModificato = checkProfiloExists(null,params.getIdProfilo());
        if(params.getNuovoTipo()!=null){
            profiloModificato.setTipo(params.getNuovoTipo());
        }
        if(params.getNuovaDescrizione()!=null){
            profiloModificato.setDescrizione(params.getNuovaDescrizione());
        }
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        return ProfiloDtoMapper.INSTANCE.toDto(profiloRepository.save(ProfiloEntityMapper.INSTANCE.toEntity(profiloModificato)));
    }
}
