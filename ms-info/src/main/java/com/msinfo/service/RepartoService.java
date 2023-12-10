package com.msinfo.service;

import com.msinfo.dto.RepartoDto;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.mapper.reparto.RepartoDtoMapper;
import com.msinfo.repository.RepartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepartoService {
    @Autowired
    private RepartoRepository repartoRepository;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    public List<RepartoDto> findAll(){
        return RepartoDtoMapper.INSTANCE.toDto(repartoRepository.findAll());
    }

}
