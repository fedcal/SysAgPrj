package com.enciclopedia.service.converter;

import com.enciclopedia.dto.MalattiaDto;
import com.enciclopedia.entity.Malattia;
import com.enciclopedia.entity.Medicinale;
import com.enciclopedia.mapper.malattia.MalattiaDtoMapper;
import com.enciclopedia.mapper.malattia.MalattiaEntityMapper;
import com.enciclopedia.mapper.medicinale.MedicinaleDtoMapper;
import com.enciclopedia.mapper.medicinale.MedicinaleEntityMapper;
import com.enciclopedia.repository.MalattiaRepository;
import com.enciclopedia.repository.MedicinaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MalattiaServiceConverter {
    @Autowired
    private MalattiaRepository repository;
    public List<MalattiaDto> findAll() {
        return MalattiaDtoMapper.INSTANCE.toDto(repository.findAll());
    }

    public MalattiaDto addMalattia(MalattiaDto toSave) {
        return MalattiaDtoMapper.INSTANCE.toDto(repository.save(MalattiaEntityMapper.INSTANCE.toEntity(toSave)));
    }

    public Optional<MalattiaDto> findByNome(String nomeMalattia) {
        Optional<Malattia> malattia = repository.findByNome(nomeMalattia);
        if(malattia.isPresent())
            return Optional.of(MalattiaDtoMapper.INSTANCE.toDto(malattia.get()));
        else
            return Optional.empty();
    }

    public Optional<MalattiaDto> findById(Integer idMalattia) {
        Optional<Malattia> malattia = repository.findById(idMalattia);
        if(malattia.isPresent())
            return Optional.of(MalattiaDtoMapper.INSTANCE.toDto(malattia.get()));
        else
            return Optional.empty();
    }
}
