package com.msinfo.controller;

import com.msinfo.constants.WebConstants;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.service.SpecialistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = WebConstants.REST_CONTEX_STRING+"/specialista")
public class SpecialistaController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private SpecialistaService specialistaService;
}
