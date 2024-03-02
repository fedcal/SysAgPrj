package com.bff.controller.msinfermiere;

import com.bff.constants.WebConstants;
import com.bff.dto.msinfermiere.InfermiereDto;
import com.bff.dto.msinfermiere.params.operazionigenerali.*;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseDto;
import com.bff.service.msinfermiere.OperazioniGeneraliServiceInfermiere;
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
@RequestMapping(value = WebConstants.REST_CONTEX_BFF + WebConstants.REST_CONTEX_INFERMIERI+"/operazioni-generali")
@Tag(name = "Microservizio infermieri", description = "ms-infermieri")
public class OperazioniGeneraliController {
    @Autowired
    private OperazioniGeneraliServiceInfermiere operazioniGeneraliService;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;


    @Operation(summary = "Lista Infermieri",
            description = "Lista Infermieri")
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
            description = "Informazioni infermiere")
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
            description = "Agggiungi infermiere")
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
            description = "Elimina infermiere")
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
            description = "Modifica infermiere")
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
            description = "Ricerca infermiere per turni")
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
