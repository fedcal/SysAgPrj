package com.msinfo.controller;

import com.msinfo.constants.WebConstants;
import com.msinfo.dto.ProfiloDto;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.GenericResponseDto;
import com.msinfo.service.ProfiloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @Operation(summary = "Recupero lista profili disponibili",
               description = "Restituisce una lista di profili disponibili")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ricerca andata a buon fine"),
            @ApiResponse(responseCode = "404", description = "Ricerca non andata a buon fine"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<ProfiloDto>>> getAll(){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(profiloService.getAll()));
    }
}
