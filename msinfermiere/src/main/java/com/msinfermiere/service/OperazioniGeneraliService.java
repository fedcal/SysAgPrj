package com.msinfermiere.service;

import com.msinfermiere.esito.EsitoMessaggiRequestContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperazioniGeneraliService {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    public String getAll() {
        return null;
    }
}
