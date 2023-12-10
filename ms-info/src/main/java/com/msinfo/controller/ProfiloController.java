package com.msinfo.controller;

import com.msinfo.constants.WebConstants;
import com.msinfo.dto.ProfiloDto;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.GenericResponseDto;
import com.msinfo.service.ProfiloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = WebConstants.REST_CONTEX_STRING+"/profilo")
public class ProfiloController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private ProfiloService profiloService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<GenericResponseDto<List<ProfiloDto>>> getAll(){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(profiloService.getAll()));
    }
}
