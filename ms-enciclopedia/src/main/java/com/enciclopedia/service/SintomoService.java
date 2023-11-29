package com.enciclopedia.service;

import com.enciclopedia.dto.SintomoDto;
import com.enciclopedia.dto.params.sintomo.SintomoChangeParams;
import com.enciclopedia.dto.params.sintomo.SintomoInfoParams;
import com.enciclopedia.dto.params.sintomo.SintomoParams;
import com.enciclopedia.entity.Sintomo;
import com.enciclopedia.mapper.sintomo.SintomoDtoMapper;
import com.enciclopedia.mapper.sintomo.SintomoEntityMapper;
import com.enciclopedia.repository.SintomoRepository;
import com.enciclopedia.service.converter.SintomoServiceConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SintomoService {
    @Autowired
    private SintomoRepository repository;
    @Autowired
    private SintomoServiceConverter serviceConverter;

    public List<SintomoDto> getAll() {
        return serviceConverter.findAll();
    }

    public SintomoDto addSintomo(SintomoParams params) {
        SintomoDto sintomoSave = new SintomoDto();
        sintomoSave.setDescrizione(params.getDescrizioneSintomo());
        sintomoSave.setNome(params.getNomeSintomo());
        return SintomoDtoMapper.INSTANCE.toDto(repository.save(SintomoEntityMapper.INSTANCE.toDto(sintomoSave)));
    }

    public SintomoDto getInfo(SintomoInfoParams params) {
        Optional<Sintomo> sintomo;
        if(params.getIdSintomo()!=null){
            sintomo = repository.findById(params.getIdSintomo());
        }else {
            sintomo = repository.findByNome(params.getNomeSintomo());
        }
        if (sintomo.isPresent())
            return SintomoDtoMapper.INSTANCE.toDto(sintomo.get());
        else
            return null;
    }

    public String deleteSintomo(SintomoInfoParams params) {
        if(params.getNomeSintomo()!=null){
            repository.deleteByNome(params.getNomeSintomo());
            return "sintomo cancellato";
        }else {
            repository.deleteById(params.getIdSintomo());
            return "sintomo cancellato";
        }
    }

    public SintomoDto changeSintomo(SintomoChangeParams params) {
        Optional<Sintomo> sintomo;
        if(params.getIdSintomo()!=null){
            sintomo = repository.findById(params.getIdSintomo());
        }else {
            sintomo = repository.findByNome(params.getNomeSintomo());
        }

        if(sintomo.isPresent()){
            SintomoDto sintomoChange = SintomoDtoMapper.INSTANCE.toDto(sintomo.get());

            if(params.getNomeSintomoNuovo()!=null){
                sintomoChange.setNome(params.getNomeSintomoNuovo());
            }
            if (params.getDescrizioneNuova()!=null){
                sintomoChange.setDescrizione(params.getDescrizioneNuova());
            }
            return SintomoDtoMapper.INSTANCE.toDto(repository.save(SintomoEntityMapper.INSTANCE.toDto(sintomoChange)));
        }else{
            return null;
        }
    }
}
