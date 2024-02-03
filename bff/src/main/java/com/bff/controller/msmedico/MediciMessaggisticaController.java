package com.bff.controller.msmedico;

import com.bff.constants.WebConstants;
import com.bff.dto.msmedico.params.messaggistica.MessaggioParamsDto;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseDto;
import com.bff.service.msmedico.MessaggisticaService;
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
@RequestMapping(WebConstants.REST_CONTEX_BFF + WebConstants.REST_CONTEX_MEDICI + "/messaggistica")
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
    public ResponseEntity<GenericResponseDto<String>> invioMessaggioInfermiere (MessaggioParamsDto messaggioDto){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(messaggisticaService.invioMessaggioInfermiere(messaggioDto)));
    }

    @Operation(summary = "Invio messaggio al robot medico",
            description = "Invio messaggio al robot medico",
            operationId = "msMedicoInvioMessaggioPaziente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Messaggio inviato"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/invio-paziente",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> invioMessaggioPaziente (MessaggioParamsDto messaggioParamsDto){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(messaggisticaService.invioMessaggioPaziente(messaggioParamsDto)));
    }

}
