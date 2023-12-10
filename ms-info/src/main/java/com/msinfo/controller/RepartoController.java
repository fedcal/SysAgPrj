package com.msinfo.controller;

import com.msinfo.constants.WebConstants;
import com.msinfo.dto.RepartoDto;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.GenericResponseDto;
import com.msinfo.service.RepartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = WebConstants.REST_CONTEX_STRING+"/reparto")
public class RepartoController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private RepartoService repartoService;


    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<GenericResponseDto<List<RepartoDto>>> getAllReparto(){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(repartoService.findAll()));
    }


    @GetMapping(value = "/info")
    private ResponseEntity<GenericResponseDto<String>> getInfoReparto(){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse("Ciao"));
    }
}
