package com.enciclopedia.service.converter;

import com.enciclopedia.dto.SintomoDto;
import com.enciclopedia.mapper.sintomo.SintomoDtoMapper;
import com.enciclopedia.repository.SintomoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SintomoServiceConverter {
    @Autowired
    private SintomoRepository repository;

    public List<SintomoDto> findAll() {
        return SintomoDtoMapper.INSTANCE.toDto(repository.findAll());
    }
}
