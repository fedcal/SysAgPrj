package com.enciclopedia.service.converter;

import com.enciclopedia.dto.MedicinaleDto;
import com.enciclopedia.dto.params.MedicinaleParams;
import com.enciclopedia.entity.Medicinale;
import com.enciclopedia.mapper.MedicinaleDtoMapper;
import com.enciclopedia.mapper.MedicinaleEntityMapper;
import com.enciclopedia.repository.MedicinaleRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicinaleServiceConverter {
    @Autowired
    private  MedicinaleRepository repository;


    public List<MedicinaleDto> findAll(){
        return MedicinaleDtoMapper.INSTANCE.toDto(repository.findAll());
    }

    public Optional<MedicinaleDto> findByNome(String nomeMedicinale) {
        Optional<Medicinale> medicinale = repository.findByNome(nomeMedicinale);
        if(medicinale.isPresent())
            return Optional.of(MedicinaleDtoMapper.INSTANCE.toDto(repository.findByNome(nomeMedicinale).get()));
        else
            return Optional.empty();
    }

    public boolean deleteMedicinale(Integer idMedicinale) {
        if (repository.existsById(idMedicinale)) {
            repository.deleteById(idMedicinale);
            return true;
        }else {
            return false;
        }
    }

    public Medicinale addMedicinale(MedicinaleDto params) {
        return repository.save(MedicinaleEntityMapper.INSTANCE.toEntity(params));
    }

    public Medicinale modificaMedicinale(Medicinale medicinale, MedicinaleParams params) {
        boolean modifica = false;
        if(params.getNome()!=null){
            medicinale.setNome(params.getNome());
            modifica = true;
        }
        if (params.getDescrizione()!=null) {
            medicinale.setDescrizione(params.getDescrizione());
            modifica = true;
        }
        if (params.getDosaggio()!=null) {
            medicinale.setDosaggio(params.getDosaggio());
            modifica = true;
        }
        if (modifica){
            repository.deleteById(medicinale.getIdMedicinale());
            return repository.save(medicinale);
        }else{
            return new Medicinale();
        }
    }
}
