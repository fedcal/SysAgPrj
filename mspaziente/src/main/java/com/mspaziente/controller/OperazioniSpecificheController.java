package com.mspaziente.controller;

import com.mspaziente.constants.WebConstants;
import com.mspaziente.esito.EsitoMessaggiRequestContextHolder;
import com.mspaziente.service.OperazioniSpecificheService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WebConstants.REST_CONTEX_STRING + "/paziente-operazioni-specifiche")
@Tag(name = "MsPazienteOperazioniSpecificheController")
public class OperazioniSpecificheController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private OperazioniSpecificheService operazioniSpecificheService;
}
