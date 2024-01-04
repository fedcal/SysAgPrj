package com.msmedico.controller;

import com.msmedico.constants.WebConstants;
import com.msmedico.esito.EsitoMessaggiRequestContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WebConstants.REST_CONTEX_STRING + "/effettua-servizio")
public class EffettuareController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
}
