package com.enciclopedia.service;

import com.enciclopedia.dto.MalattiaDto;
import com.enciclopedia.dto.params.malattia.MalattiaChangeInfoParams;
import com.enciclopedia.dto.params.malattia.MalattiaInfoParams;
import com.enciclopedia.dto.params.malattia.MalattiaParams;

import com.enciclopedia.entity.Malattia;

import com.enciclopedia.esito.EsitoMessaggiRequestContextHolder;
import com.enciclopedia.esito.costants.EsitoOperazioneEnum;
import com.enciclopedia.exception.EsitoRuntimeException;
import com.enciclopedia.repository.MalattiaRepository;
import com.enciclopedia.service.converter.MalattiaServiceConverter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MalattiaService {
    @Autowired
    private MalattiaServiceConverter serviceConverter;
    @Autowired
    private MalattiaRepository repository;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
    public List<MalattiaDto> findAllMalattie() {
        return serviceConverter.findAll();

    }

    public MalattiaDto addMalattia(MalattiaParams params) {
        checkParamsAddMalattia(params);
        Optional<Malattia> findMalattia = repository.findByNome(params.getNome());
        if (findMalattia.isPresent()){
            return null;
        }else{
            MalattiaDto toSave = new MalattiaDto();
            toSave.setNome(params.getNome());
            toSave.setDescrizione(params.getDescrizione());
            return serviceConverter.addMalattia(toSave);
        }
    }

    private void checkParamsAddMalattia(MalattiaParams params) {
        if(params.getDescrizione()==null || params.getNome()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.setOperationId("Inserire il nome e la descrizione della malattia che si " +
                    "vuole inserire.");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public MalattiaDto findMalattiaInfo(MalattiaInfoParams params) {
        checkParamsMalattiaInfo(params);
        Optional<MalattiaDto> malattiaDto;
        if(params.getNomeMalattia()!=null)
            malattiaDto = serviceConverter.findByNome(params.getNomeMalattia());
        else
            malattiaDto = serviceConverter.findById(params.getIdMalattia());
        if (malattiaDto.isPresent()){
            return malattiaDto.get();
        }else{
            return null;
        }
    }

    private void checkParamsMalattiaInfo(MalattiaInfoParams params) {
        if(params.getIdMalattia()==null && params.getNomeMalattia()==null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.setOperationId("Inserire l'id o il nome della malattia.");
            throw  new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    public MalattiaDto changeInfoMalattia(MalattiaChangeInfoParams params) {
        Optional<MalattiaDto> malattiaDto;
        if(params.getNome()!=null)
            malattiaDto = serviceConverter.findByNome(params.getNome());
        else
            malattiaDto = serviceConverter.findById(params.getId());

        if (malattiaDto.isPresent()){
            MalattiaDto malattiaToSave = malattiaDto.get();
            if (params.getNuovoNome()!= null){
                malattiaToSave.setNome(params.getNuovoNome());
                serviceConverter.addMalattia(malattiaToSave);
            }else if(params.getNuovaDescrizione()!=null){
                malattiaToSave.setDescrizione(params.getNuovaDescrizione());
                serviceConverter.addMalattia(malattiaToSave);
            }
            return malattiaToSave;
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.setOperationId("La malattia da te indicata non è presente");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }
    }

    public String deleteMalattia(MalattiaInfoParams params) {
        try {
            if(params.getIdMalattia()!=null){
                repository.deleteById(params.getIdMalattia());
                return "Malattia Eliminata";
            }else {
                repository.deleteByNome(params.getNomeMalattia());
                return "Malattia Eliminata";
            }
        }catch (IllegalArgumentException e){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.setOperationId("La malattia da te indicata non è stata eliminata. Prova a " +
                    "indicare un id o un nome corretto.");
            throw  new EsitoRuntimeException(HttpStatus.NOT_FOUND);
        }

    }
}
