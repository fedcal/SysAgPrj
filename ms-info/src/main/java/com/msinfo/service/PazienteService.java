package com.msinfo.service;

import com.msinfo.dto.PazienteDto;
import com.msinfo.mapper.pazienti.paziente.PazienteDtoMapper;
import com.msinfo.repository.PazienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PazienteService {
    @Autowired
    private PazienteRepository pazienteRepository;

    public List<PazienteDto> findAll(){
        return PazienteDtoMapper.INSTANCE.toDto(pazienteRepository.findAll());
    }
}
