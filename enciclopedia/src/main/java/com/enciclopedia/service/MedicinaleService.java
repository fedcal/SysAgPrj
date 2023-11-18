package com.enciclopedia.service;

import com.enciclopedia.dto.MedicinaleDto;
import com.enciclopedia.dto.params.MedicinaleParams;
import com.enciclopedia.entity.Medicinale;
import com.enciclopedia.repository.MedicinaleRepository;
import com.enciclopedia.service.converter.MedicinaleServiceConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicinaleService {

    @Autowired
    private MedicinaleServiceConverter serviceConverter;
    @Autowired
    private MedicinaleRepository repository;

    public List<MedicinaleDto> findAllMedicinali(){
        return  serviceConverter.findAll();
    }

    public MedicinaleDto findByNome(String nomeMedicinale) {
        Optional<MedicinaleDto> medicinaleDto = serviceConverter.findByNome(nomeMedicinale);
        if (medicinaleDto.isPresent()){
            return medicinaleDto.get();
        }else{
            return null;
        }
    }

    public boolean deleteMedicinale(Integer idMedicinale) {
        if (repository.existsById(idMedicinale)) {
            repository.deleteById(idMedicinale);
            return true;
        }else {
            return false;
        }
    }

    public boolean deleteMedicinaleByNome(String nomeMedicinale) {
        Optional<MedicinaleDto> medicinaleDto = serviceConverter.findByNome(nomeMedicinale);
        if (medicinaleDto.isPresent()){
            repository.deleteById(medicinaleDto.get().getIdMedicinale());
            return true;
        }else{
            return false;
        }

    }

    public Medicinale addMedicinale(MedicinaleParams params) {
        if(repository.findByNome(params.getNome()).isPresent()){
            return new Medicinale();
        }else {
            MedicinaleDto toSave = new MedicinaleDto();
            toSave.setIdMedicinale(repository.findAll().size() + 1);
            toSave.setNome(params.getNome());
            toSave.setDescrizione(params.getDescrizione());
            toSave.setDosaggio(params.getDosaggio());
            return serviceConverter.addMedicinale(toSave);
        }
    }

    public Medicinale modificaMedicinalle(Integer idMedicinale, MedicinaleParams params) {
        Optional<Medicinale> medicinale = repository.findById(idMedicinale);
        if(medicinale.isPresent()){
            return serviceConverter.modificaMedicinale(medicinale.get(),params);
        }else {
            return null;
        }


    }
}
