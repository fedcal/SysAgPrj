package com.msinfermiere.controller;

import com.msinfermiere.constants.WebConstants;
import com.msinfermiere.dto.InfermiereDto;
import com.msinfermiere.dto.params.MessaggioParamsDto;
import com.msinfermiere.dto.params.operazionigenerali.*;
import com.msinfermiere.esito.EsitoMessaggiRequestContextHolder;
import com.msinfermiere.esito.GenericResponseDto;
import com.msinfermiere.service.OperazioniGeneraliService;
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
@RequestMapping(WebConstants.REST_CONTEX_STRING + "/operazioni-generali")
@Tag(name ="MsInfermieriOperazioniGeneraliController")
public class OperazioniGeneraliController {
    @Autowired
    private OperazioniGeneraliService operazioniGeneraliService;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Operation(summary = "Lista Infermieri",
            description = "Lista Infermieri",
            operationId = "msInfermiereGetAll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista infermieri"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-infermieri",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<InfermiereDto>>> getAllInfermieri (){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniGeneraliService.getAll()));
    }

    @Operation(summary = "Informazioni infermiere",
            description = "Informazioni infermiere",
            operationId = "msInfermiereInformazioniInfermiere")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informazioni infermiere"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Infermiere non trovato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/informazioni-infermiere",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<InfermiereDto>>> getInfermiereInfo (@ParameterObject InfermiereInfoParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniGeneraliService.getInfermiereInfo(params)));
    }

    @Operation(summary = "Agggiungi infermiere",
            description = "Agggiungi infermiere",
            operationId = "msInfermiereAddInfermiere")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informazioni infermiere"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Infermiere non trovato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/aggiungi-infermiere",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<InfermiereDto>> addInfermiere (@ParameterObject InfermiereAddParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniGeneraliService.addInfermiere(params)));
    }

    @Operation(summary = "Elimina infermiere",
            description = "Elimina infermiere",
            operationId = "msInfermiereDeleteInfermiere")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Infermiere eliminato"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Infermiere non trovato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @DeleteMapping(value ="/elimina-infermiere",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> deleteInfermiere (@ParameterObject InfermiereDeleteParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniGeneraliService.deleteInfermiere(params)));
    }

    @Operation(summary = "Modifica infermiere",
            description = "Modifica infermiere",
            operationId = "msInfermiereModificaInfermiere")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Infermiere modificato"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Infermiere non trovato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PutMapping(value ="/modifica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<InfermiereDto>> modifyInfermiere (@ParameterObject InfermiereModifyParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniGeneraliService.modifyInfermiere(params)));
    }
    @Operation(summary = "Ricerca infermiere per turni",
            description = "Ricerca infermiere per turni",
            operationId = "msInfermiereRicercaTramiteTurni")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Infermiere modificato"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Infermiere non trovato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/modifica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<InfermiereDto>>> ricercaInfermiereTramiteTurno (@ParameterObject InfermieriTurniParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniGeneraliService.ricercaInfermiereTramiteTurno(params)));
    }
}
