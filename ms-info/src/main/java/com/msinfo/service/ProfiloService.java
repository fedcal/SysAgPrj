package com.msinfo.service;

import com.msinfo.dto.ProfiloDto;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.mapper.account.profilo.ProfiloDtoMapper;
import com.msinfo.repository.ProfiloRepository;
import com.msinfo.repository.RepartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfiloService {
    @Autowired
    private ProfiloRepository profiloRepository;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    public List<ProfiloDto> getAll(){
        return ProfiloDtoMapper.INSTANCE.toDto(profiloRepository.findAll());
    }
}
