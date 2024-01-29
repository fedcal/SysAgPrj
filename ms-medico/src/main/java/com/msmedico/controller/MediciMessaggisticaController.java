package com.msmedico.controller;

import com.msmedico.constants.WebConstants;
import com.msmedico.dto.params.messaggistica.infermiere.InfermiereMedicoMessaggioDto;
import com.msmedico.dto.params.messaggistica.infermiere.MedicoInfermiereMessaggioDto;
import com.msmedico.esito.EsitoMessaggiRequestContextHolder;
import com.msmedico.esito.GenericResponseDto;
import com.msmedico.service.MessaggisticaService;
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
@RequestMapping(WebConstants.REST_CONTEX_STRING + "/messagistica")
public class MediciMessaggisticaController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
    @Autowired
    private MessaggisticaService messaggisticaService;
    @Operation(summary = "Invio messaggio al robot infermiere",
            description = "Invio messaggio al robot infermiere",
            operationId = "msMedicoInvioMessaggioInfermiere")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Messaggio inviato"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/invio-infermiere",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> invioMessaggioInfermiere (MedicoInfermiereMessaggioDto messaggioDto){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(messaggisticaService.invioMessaggioInfermiere(messaggioDto)));
    }

    @Operation(summary = "Ricevi messaggio dal robot infermiere",
            description = "Ricevi messaggio dal robot infermiere",
            operationId = "msMedicoRiceviMessaggioInfermiere")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Messaggio inviato"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/ricevi-infermiere",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> riceviMessaggioInfermiere (InfermiereMedicoMessaggioDto messaggioDto){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(messaggisticaService.riceviMessaggioInfermiere(messaggioDto)));
    }
}
