package com.enciclopedia.service;

import com.enciclopedia.dto.SintomoMalattiaDto;
import com.enciclopedia.dto.params.SintomoMalattiaParams;
import com.enciclopedia.entity.relationship.SintomoMalattia;
import com.enciclopedia.mapper.sintomomalattia.SintomoMalattiaDtoMapper;
import com.enciclopedia.repository.SintomoMalattiaRepository;
import com.enciclopedia.service.converter.SintomoMalattiaConverterSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class SintomoMalattiaService {
    @Autowired
    private SintomoMalattiaConverterSevice serviceConvert;
    @Autowired
    private SintomoMalattiaRepository repository;

    public List<SintomoMalattiaDto> getAll() {
        return SintomoMalattiaDtoMapper.INSTANCE.toDto(repository.findAll());
    }

    public SintomoMalattiaDto addSintomo(SintomoMalattiaParams params) {
        List<SintomoMalattia> listaSintomo = repository.findBySintomo(params.getIdSintomo());
        SintomoMalattia toSave = new SintomoMalattia();
        toSave.setIdMalattia(params.getIdMalattia());
        toSave.setIdSintomo(params.getIdSintomo());
        toSave.setIdRelazione(1);
        if(listaSintomo.isEmpty()) {
            return SintomoMalattiaDtoMapper.INSTANCE.toDto(repository.save(toSave));
        }else{
            AtomicBoolean isPresent = new AtomicBoolean(false);
            listaSintomo.stream().forEach(e->{
                if(e.getIdMalattia() == params.getIdMalattia() && e.getIdSintomo() == params.getIdSintomo())
                    isPresent.set(true);
            });
            if (isPresent.get()){
                return null;
            }else{
                List<SintomoMalattia> listaTotale = repository.findAll();
                toSave.setIdRelazione(listaTotale.size()+1);
                return SintomoMalattiaDtoMapper.INSTANCE.toDto(repository.save(toSave));
            }
        }
    }
}
