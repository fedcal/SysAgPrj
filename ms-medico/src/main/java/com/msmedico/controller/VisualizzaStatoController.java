package com.msmedico.controller;

import com.msmedico.constants.WebConstants;
import com.msmedico.dto.MedicoDto;
import com.msmedico.dto.params.visualizzastato.FindStatoVisitaMedicaParams;
import com.msmedico.dto.relationentities.VisitaMedicaCartellaDto;
import com.msmedico.esito.EsitoMessaggiRequestContextHolder;
import com.msmedico.esito.GenericResponseDto;
import com.msmedico.service.VisualizzaStatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(WebConstants.REST_CONTEX_STRING + "/visualizza-stato")
public class VisualizzaStatoController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private VisualizzaStatoService visualizzaStatoService;

    @Operation(summary = "Elenco di tutti i medici",
            description = "Restituisce una lista di MediciDto che racchiude tutte le informazioni relaitive ai medici",
            operationId = "msMedicoGetStatoVisita")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elenco di tutti i medici"),
            @ApiResponse(responseCode = "404", description = "Nessun elenco disponibile"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/visita",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<VisitaMedicaCartellaDto>>> getStatoVisita(@ParameterObject FindStatoVisitaMedicaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(visualizzaStatoService.statoVisita(params)));
    }
}
