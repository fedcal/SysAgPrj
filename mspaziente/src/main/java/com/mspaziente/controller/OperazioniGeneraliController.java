package com.mspaziente.controller;


import com.mspaziente.constants.WebConstants;
import com.mspaziente.dto.PazienteDto;
import com.mspaziente.dto.params.operazionigenerali.AddPazienteParams;
import com.mspaziente.dto.params.operazionigenerali.FindPazienteParams;
import com.mspaziente.dto.params.operazionigenerali.ModificaPazienteParams;
import com.mspaziente.esito.EsitoMessaggiRequestContextHolder;
import com.mspaziente.esito.GenericResponseDto;
import com.mspaziente.service.OperazioniGeneraliService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(WebConstants.REST_CONTEX_STRING + "/paziente-operazioni-generali")
@Tag(name ="MsPazientiOperazioniGeneraliController")
public class OperazioniGeneraliController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private OperazioniGeneraliService operazioniGeneraliService;

    @Operation(summary = "Lista pazienti",
            description = "Lista pazienti",
            operationId = "msPazienteListaPazienti")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista trovata"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata trovata"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-pazienti",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<PazienteDto>>> findAllPazienti (){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniGeneraliService.getAllPazienti()));
    }

    @Operation(summary = "Lista pazienti filtrata",
            description = "Lista pazienti filtrata",
            operationId = "msPazienteInfoPazienti")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista trovata"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata trovata"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/info-paziente",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<PazienteDto>>> findInfoPazienti (@ParameterObject FindPazienteParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniGeneraliService.findInfoPazienti(params)));
    }

    @Operation(summary = "Aggiungi paziente",
            description = "Aggiungi paziente",
            operationId = "msPazienteAggiungiPaziente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paziente aggiunto"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/aggiunta-paziente",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<PazienteDto>> addInfoPazienti (@ParameterObject AddPazienteParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniGeneraliService.addInfoPazienti(params)));
    }

    @Operation(summary = "Elimina paziente",
            description = "Elimina paziente",
            operationId = "msPazienteEliminaPazienti")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista trovata"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @DeleteMapping(value ="/elimina-paziente/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> deleteInfoPazienti (@PathVariable("id") Integer idPaziente){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniGeneraliService.deleteInfoPazienti(idPaziente)));
    }

    @Operation(summary = "Modifica paziente",
            description = "Modifica paziente",
            operationId = "msPazienteModificaPaziente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paziente modificato"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/modifica-paziente",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<PazienteDto>> modificaInfoPazienti (@ParameterObject ModificaPazienteParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniGeneraliService.modificaInfoPazienti(params)));
    }
}
