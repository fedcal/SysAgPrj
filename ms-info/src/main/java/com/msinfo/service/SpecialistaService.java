package com.msinfo.service;

import com.msinfo.dto.SpecialistaDto;
import com.msinfo.dto.params.specialista.AddSpecialistaParams;
import com.msinfo.dto.params.specialista.FindSpecialistaParams;
import com.msinfo.dto.params.specialista.ModifySpecialistaParams;
import com.msinfo.entity.account.Profilo;
import com.msinfo.entity.specialista.Specialista;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.Messaggio;
import com.msinfo.esito.constants.EsitoOperazioneEnum;
import com.msinfo.esito.constants.SeveritaMessaggioEnum;
import com.msinfo.exception.EsitoRuntimeException;
import com.msinfo.mapper.account.profilo.ProfiloDtoMapper;
import com.msinfo.mapper.specialista.SpecialistaDtoMapper;
import com.msinfo.mapper.specialista.SpecialistaEntityMapper;
import com.msinfo.repository.ProfiloRepository;
import com.msinfo.repository.SpecialistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpecialistaService {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private SpecialistaRepository specialistaRepository;

    @Autowired
    private ProfiloRepository profiloRepository;

    public List<SpecialistaDto> findAll() {
        List<SpecialistaDto> specialistaLista = SpecialistaDtoMapper.INSTANCE.toDto(specialistaRepository.findAll());
        if(specialistaLista.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna lista di infermieri trovata").build());
            esitoMessaggiRequestContextHolder.setOperationId("findAll");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            return specialistaLista;
        }
    }

    public List<SpecialistaDto> findSpecialista(FindSpecialistaParams params) {
        List<SpecialistaDto> findSpecialista = new ArrayList<>();
        List<Specialista> findSpecialisti = new ArrayList<>();

        if(params.getIdSpecialista()!=null){
            Optional<Specialista> findSpecialistaId = specialistaRepository.findById(params.getIdSpecialista());
            if(findSpecialistaId.isPresent()){
                findSpecialista.add(SpecialistaDtoMapper.INSTANCE.toDto(findSpecialistaId.get()));
            }else{
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Nessun specialista trovato").build());
                esitoMessaggiRequestContextHolder.setOperationId("findSpecialista");
                throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
            }
        }else if (params.getNome()!=null && params.getCognome()!=null){
            findSpecialisti = specialistaRepository.findByNomeAndCognome(params.getNome(),params.getCognome());
        }else if (params.getNome()!=null){
            findSpecialisti = specialistaRepository.findByNome(params.getNome());
        } else if (params.getCognome()!=null) {
            findSpecialisti = specialistaRepository.findByCognome(params.getCognome());
        }
        if(findSpecialisti.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun specialista trovato").build());
            esitoMessaggiRequestContextHolder.setOperationId("findSpecialista");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            findSpecialista.addAll(SpecialistaDtoMapper.INSTANCE.toDto(findSpecialisti));
        }
        return findSpecialista;
    }

    public String deleteSpecialista(Integer id) {
        Optional<Specialista> specialistaFind = specialistaRepository.findById(id);
        if(specialistaFind.isPresent()){
            try{
                specialistaRepository.deleteById(id);
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
                return "Specialista eliminato";
            }catch (Exception e){
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Impossibili eliminare lo specialista").build());
                esitoMessaggiRequestContextHolder.setOperationId("deleteSpecialista");
                throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
            }
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun speicalista trovato").build());
            esitoMessaggiRequestContextHolder.setOperationId("deleteSpecialista");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
    }

    public SpecialistaDto modifySpecialista(ModifySpecialistaParams params) {
        Optional<Specialista> specialistaFind = specialistaRepository.findById(params.getIdSpecialista());
        if(!specialistaFind.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun speicalista trovato").build());
            esitoMessaggiRequestContextHolder.setOperationId("deleteSpecialista");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{
            if(params.getNuovoNome()!=null){
                specialistaFind.get().setNome(params.getNuovoNome());
            }
            if(params.getNuovoCognome()!=null){
                specialistaFind.get().setCognome(params.getNuovoCognome());
            }
            if(params.getNuovoTurno()!=null){
                specialistaFind.get().setTurno(params.getNuovoTurno());
            }
            if(params.getNuovaSpecializzazione()!=null){
                specialistaFind.get().setSpecializzazione(params.getNuovaSpecializzazione());
            }
            if(params.getNuovoProfilo()!=null){
                Optional<Profilo> profiloFind = profiloRepository.findById(params.getNuovoProfilo());
                if(!profiloFind.isPresent()){
                    esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                    esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                            .codMsg("Nessun profilo trovato").build());
                    esitoMessaggiRequestContextHolder.setOperationId("deleteSpecialista");
                    throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
                }else {
                    specialistaFind.get().setProfilo(profiloFind.get());
                }
            }
        }
        specialistaRepository.save(specialistaFind.get());
        return SpecialistaDtoMapper.INSTANCE.toDto(specialistaFind.get());
    }

    public SpecialistaDto addSpecialista(AddSpecialistaParams params) {
        SpecialistaDto specialistaDto = new SpecialistaDto();

        specialistaDto.setIdSpecialista(specialistaRepository.findAll().size()+1);
        specialistaDto.setNome(params.getNome());
        specialistaDto.setCognome(params.getCognome());
        specialistaDto.setTurno(params.getTurno());
        specialistaDto.setSpecializzazione(params.getSpecializzazione());

        Optional<Profilo> profiloFind = profiloRepository.findById(params.getProfilo());
        if(!profiloFind.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessun profilo trovato").build());
            esitoMessaggiRequestContextHolder.setOperationId("deleteSpecialista");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else {
            specialistaDto.setProfilo(ProfiloDtoMapper.INSTANCE.toDto(profiloFind.get()));
        }

        specialistaRepository.save(SpecialistaEntityMapper.INSTANCE.toEntity(specialistaDto));
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        return specialistaDto;
    }
}
