package com.msinfo.service;

import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.repository.SpecialistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialistaService {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private SpecialistaRepository specialistaRepository;
}
