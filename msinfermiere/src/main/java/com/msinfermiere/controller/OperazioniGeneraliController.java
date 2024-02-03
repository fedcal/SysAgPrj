package com.msinfermiere.controller;

import com.msinfermiere.constants.WebConstants;
import com.msinfermiere.dto.params.MessaggioParamsDto;
import com.msinfermiere.esito.EsitoMessaggiRequestContextHolder;
import com.msinfermiere.esito.GenericResponseDto;
import com.msinfermiere.service.OperazioniGeneraliService;
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
@RequestMapping(WebConstants.REST_CONTEX_STRING + "/operazioni-generali")
public class OperazioniGeneraliController {
    @Autowired
    private OperazioniGeneraliService operazioniGeneraliService;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Operation(summary = "Invio messaggio al robot medico",
            description = "Invio messaggio al robot medico",
            operationId = "msInfermiereInvioMessaggioMedico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Messaggio inviato"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-infermieri",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> invioMessaggioMedico (){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniGeneraliService.getAll()));
    }
}
