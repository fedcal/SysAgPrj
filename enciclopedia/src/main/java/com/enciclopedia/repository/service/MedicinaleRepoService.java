package com.enciclopedia.repository.service;

import com.enciclopedia.entity.dto.MedicinaleDto;
import com.enciclopedia.entity.mapper.MedicinaleMapper;
import com.enciclopedia.repository.MedicinaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicinaleRepoService {
    @Autowired
    private MedicinaleRepository repository;
    @Autowired
    private MedicinaleMapper mapper;

    public List<MedicinaleDto> findAllMedicinali(){
        return mapper.toDto(repository.findAll());
    }
}
