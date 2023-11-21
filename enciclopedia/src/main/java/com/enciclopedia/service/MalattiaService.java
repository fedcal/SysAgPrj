package com.enciclopedia.service;

import com.enciclopedia.dto.MalattiaDto;
import com.enciclopedia.dto.params.MalattiaChangeInfoParams;
import com.enciclopedia.dto.params.MalattiaInfoParams;
import com.enciclopedia.dto.params.MalattiaParams;

import com.enciclopedia.entity.Malattia;

import com.enciclopedia.mapper.malattia.MalattiaDtoMapper;
import com.enciclopedia.mapper.malattia.MalattiaEntityMapper;
import com.enciclopedia.mapper.medicinale.MedicinaleDtoMapper;
import com.enciclopedia.repository.MalattiaRepository;
import com.enciclopedia.service.converter.MalattiaServiceConverter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<MalattiaDto> findAllMalattie() {
        return serviceConverter.findAll();

    }

    public MalattiaDto addMalattia(MalattiaParams params) {

        Optional<Malattia> findMalattia = repository.findByNome(params.getNome());
        if (findMalattia.isPresent()){
            return null;
        }else{
            MalattiaDto toSave = new MalattiaDto();
            toSave.setIdMalattia(repository.findAll().size()+1);
            toSave.setNome(params.getNome());
            toSave.setDescrizione(params.getDescrizione());
            return serviceConverter.addMalattia(toSave);
        }
    }

    public MalattiaDto findMalattiaByName(MalattiaInfoParams params) {
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
            return null;
        }
    }
}
