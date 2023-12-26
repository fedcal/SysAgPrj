package com.msinfo.controller;

import com.msinfo.constants.WebConstants;
import com.msinfo.dto.InfermiereDto;
import com.msinfo.dto.params.infermieri.FindInfermiereParams;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.GenericResponseDto;
import com.msinfo.service.InfermieriService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.websocket.server.PathParam;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = WebConstants.REST_CONTEX_STRING+"/infermieri")
public class InfermieriController {

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private InfermieriService infermieriService;

    @Operation(summary = "Elenco di tutti gli infermieri",
            description = "Restituisce una lista di InfermiereDto che racchiude tutte le informazioni relaitive agli infermieri")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elenco di tutti gli infermieri"),
            @ApiResponse(responseCode = "404", description = "Nessun elenco disponibile"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/findAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<InfermiereDto>>> getAll(){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(infermieriService.findAll()));
    }

    @Operation(summary = "Filtraggio degli infermieri",
            description = "Restituisce una lista di InfermiereDto seguendo i filtri")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elenco di tutti gli infermieri"),
            @ApiResponse(responseCode = "404", description = "Nessun elenco disponibile"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/find",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<InfermiereDto>>> findInfermiere(@ParameterObject FindInfermiereParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(infermieriService.findInfermiere(params)));
    }

    @Operation(summary = "Eliminare un infermiere",
            description = "Restituisce una lista di InfermiereDto che racchiude tutte le informazioni relaitive agli infermieri")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elenco di tutti gli infermieri"),
            @ApiResponse(responseCode = "404", description = "Nessun elenco disponibile"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @DeleteMapping(value ="/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> deleteInfermiere(@ParameterObject @PathVariable Integer id){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(infermieriService.deleteInfermiere(id)));
    }
}
