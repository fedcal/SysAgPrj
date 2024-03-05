package com.mspaziente.controller;

import com.mspaziente.constants.WebConstants;
import com.mspaziente.dto.params.MessaggioParamsDto;
import com.mspaziente.esito.EsitoMessaggiRequestContextHolder;
import com.mspaziente.esito.GenericResponseDto;
import com.mspaziente.service.MessaggisticaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WebConstants.REST_CONTEX_STRING + "/messagistica")
@Tag(name ="MsPazientiMessaggisticaController")
public class PazientiMessaggisticaController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private MessaggisticaService messaggisticaService;

    @Operation(summary = "Invio messaggio al robot infermiere",
            description = "Invio messaggio al robot infermiere",
            operationId = "msPazienteInvioMessaggioInfermiere")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Messaggio inviato"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/invio-infermiere",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> invioMessaggioInfermiere (MessaggioParamsDto messaggioDto){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(messaggisticaService.invioMessaggioInfermiere(messaggioDto)));
    }

    @Operation(summary = "Ricevi messaggio dal robot infermiere",
            description = "Ricevi messaggio dal robot infermiere",
            operationId = "msPazienteRiceviMessaggioInfermiere")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Messaggio inviato"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/ricevi-infermiere",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> riceviMessaggioInfermiere (MessaggioParamsDto messaggioDto){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(messaggisticaService.riceviMessaggioInfermiere(messaggioDto)));
    }

    @Operation(summary = "Invio messaggio al robot medico",
            description = "Invio messaggio al robot medico",
            operationId = "msPazienteInvioMessaggioMedico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Messaggio inviato"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/invio-medico",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> invioMessaggioPaziente (MessaggioParamsDto messaggioParamsDto){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(messaggisticaService.invioMessaggioMedico(messaggioParamsDto)));
    }

    @Operation(summary = "Ricevi messaggio dal robot medico",
            description = "Ricevi messaggio dal robot medico",
            operationId = "msPazienteRiceviMessaggioMedico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Messaggio inviato"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/ricevi-medico",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> riceviMessaggioPaziente (MessaggioParamsDto messaggioParamsDto){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(messaggisticaService.riceviMessaggioMedico(messaggioParamsDto)));

    }
}
