package com.msinfo.service;

import com.msinfo.dto.InfermiereDto;
import com.msinfo.dto.params.infermieri.AddInfermiereParams;
import com.msinfo.dto.params.infermieri.FindInfermiereParams;
import com.msinfo.dto.params.infermieri.ModifyInfermiereParams;
import com.msinfo.entity.account.Profilo;
import com.msinfo.entity.infermieri.Infermiere;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.Messaggio;
import com.msinfo.esito.constants.EsitoOperazioneEnum;
import com.msinfo.esito.constants.SeveritaMessaggioEnum;
import com.msinfo.exception.EsitoRuntimeException;
import com.msinfo.mapper.account.profilo.ProfiloDtoMapper;
import com.msinfo.mapper.infermieri.InfermiereDtoMapper;
import com.msinfo.mapper.infermieri.InfermiereEnityMapper;
import com.msinfo.repository.InfermiereRepository;
import com.msinfo.repository.ProfiloRepository;
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

    @Autowired
    private ProfiloRepository profiloRepository;

    public List<InfermiereDto> findAll() {
        List<InfermiereDto> catchAll = InfermiereDtoMapper.INSTANCE.toDto(infermiereRepository.findAll());
        if(catchAll.isEmpty()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Nessuna lista di infermieri trovata.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findAll");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
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
                    .codMsg("Non esiste alcun infermiere che corrisponde ai parametri di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findInfermiere");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    private void checkParams(FindInfermiereParams params) {
        if(params.getIdInfermiere() == null && params.getCognomeInfermiere() == null && params.getNomeInfermiere() == null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire almeno un parametro di ricerca.").build());
            esitoMessaggiRequestContextHolder.setOperationId("findInfermiere");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public String deleteInfermiere(Integer id) {
        if (infermiereRepository.findById(id).isPresent()){
            try{
                infermiereRepository.deleteById(id);
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
                return "Infermiere eliminato";
            }catch (Exception e){
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("L'infermiere non è stato eliminato.").build());
                esitoMessaggiRequestContextHolder.setOperationId("deleteInfermiere");
                throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
            }
        }else {
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Infermiere non trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("deleteInfermiere");
            throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
    }

    public InfermiereDto modifyInfermiere(ModifyInfermiereParams params) {
        if(params.getIdInfermiere()!=null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Inserire l'id dell'infermiere da modificare.").build());
            esitoMessaggiRequestContextHolder.setOperationId("modifyInfermiere");
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }

        Optional<Infermiere> findInfermiere = infermiereRepository.findById(params.getIdInfermiere());
        
        if(!findInfermiere.isPresent()){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                    .codMsg("Infermiere non trovato.").build());
            esitoMessaggiRequestContextHolder.setOperationId("modifyInfermiere");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }else{

            if(params.getNuovoNome()!=null){
                findInfermiere.get().setNome(params.getNuovoNome());
            }

            if(params.getNuovoCognome()!=null){
                findInfermiere.get().setCognome(params.getNuovoCognome());
            }

            if(params.getNuovoTurno()!=null){
                findInfermiere.get().setTurno(params.getNuovoTurno());
            }

            if(params.getNuovoProfilo()!=null){
                Optional<Profilo> profiloFind = profiloRepository.findById(params.getNuovoProfilo());
                if(!profiloFind.isPresent()){
                    esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                    esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                            .codMsg("Nuovo profilo non trovato.").build());
                    esitoMessaggiRequestContextHolder.setOperationId("modifyInfermiere");
                    throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
                }else{
                    findInfermiere.get().setProfilo(profiloFind.get());
                }
            }
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            return InfermiereDtoMapper.INSTANCE.toDto(infermiereRepository.save(findInfermiere.get()));
        }
    }

    public InfermiereDto addInfermiere(AddInfermiereParams params) {
        InfermiereDto infermiereDto = new InfermiereDto();

        infermiereDto.setIdInfermiere(infermiereRepository.findAll().size() + 1);
        infermiereDto.setNome(params.getNome());
        infermiereDto.setCognome(params.getCognome());
        infermiereDto.setTurno(params.getTurno());

        if (params.getProfilo() != null) {
            Optional<Profilo> profilo = profiloRepository.findById(params.getProfilo());
            if (profilo.isPresent()) {
                infermiereDto.setProfilo(ProfiloDtoMapper.INSTANCE.toDto(profilo.get()));
            } else {
                esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
                esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR)
                        .codMsg("Profilo non trovato.").build());
                esitoMessaggiRequestContextHolder.setOperationId("modifyInfermiere");
                throw new EsitoRuntimeException(HttpStatus.NOT_FOUND);
            }
        }

        infermiereRepository.save(InfermiereEnityMapper.INSTANCE.toEntity(infermiereDto));

        return infermiereDto;
    }
}
