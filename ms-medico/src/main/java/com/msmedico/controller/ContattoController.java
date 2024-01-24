package com.msmedico.controller;

import com.msmedico.constants.WebConstants;
import com.msmedico.esito.EsitoMessaggiRequestContextHolder;
import com.msmedico.esito.GenericResponseDto;
import com.msmedico.service.ContattaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WebConstants.REST_CONTEX_STRING + "/contatta")
public class ContattoController {
    @Autowired
    private ContattaService contattaService;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
    @Operation(summary = "Informazione di una prescrizione di una visita",
            description = "Informazione di una prescrizione di una visita",
            operationId = "msMedicoprescriviVisitaInfo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione medicinale aggiunta"),
            @ApiResponse(responseCode = "404", description = "Nessun medicinale aggiunta"),
            @ApiResponse(responseCode = "400", description = "Comportamento inaspettato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/visita-info",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> contattaInfermiere(String msg){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(contattaService.contattaInfermiere(msg)));
    }
}
