package com.msinfermiere.controller;

import com.msinfermiere.constants.WebConstants;
import com.msinfermiere.dto.params.messaggimedico.InfermiereMedicoMessaggioDto;
import com.msinfermiere.dto.params.messaggimedico.MedicoInfermiereMessaggioDto;
import com.msinfermiere.esito.EsitoMessaggiRequestContextHolder;
import com.msinfermiere.esito.GenericResponseDto;
import com.msinfermiere.service.MessaggisticaService;
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
public class InfermieriMessaggisticaController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
    @Autowired
    private MessaggisticaService messaggisticaService;
    @Operation(summary = "Invio messaggio al robot medico",
            description = "Invio messaggio al robot medico",
            operationId = "msMedicoInvioMessaggioInfermiere")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Messaggio inviato"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/invio-medico",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> invioMessaggioInfermiere (InfermiereMedicoMessaggioDto messaggioDto){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(messaggisticaService.invioMessaggioMedico(messaggioDto)));
    }

    @Operation(summary = "Ricevi messaggio dal robot medico",
            description = "Ricevi messaggio dal robot medico",
            operationId = "msMedicoRiceviMessaggioInfermiere")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Messaggio inviato"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/ricevi-meidco",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> riceviMessaggioInfermiere (MedicoInfermiereMessaggioDto messaggioDto){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(messaggisticaService.riceviMessaggioMedico(messaggioDto)));
    }
}
