package com.msinfo.controller;

import com.msinfo.constants.WebConstants;
import com.msinfo.dto.RepartoDto;
import com.msinfo.dto.params.reparto.AddRepartoParams;
import com.msinfo.dto.params.reparto.ModificaRepartoParams;
import com.msinfo.dto.params.reparto.RicercaRepartoParams;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.GenericResponseDto;
import com.msinfo.service.RepartoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = WebConstants.REST_CONTEX_STRING+"/reparto")
public class RepartoController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private RepartoService repartoService;

    @Operation(summary = "Recuperare le informazioni di tutti i reparti",
            description = "Restituisce le informazioni di tutti i reparti")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recupero informazioni andato a buon fine"),
            @ApiResponse(responseCode = "404", description = "Informazioni non trovate"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<RepartoDto>>> getAllReparto(){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(repartoService.findAll()));
    }

    @Operation(summary = "Recuperare le informazioni di un reparto",
            description = "Restituisce le informazioni di un reparto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recupero informazioni andato a buon fine"),
            @ApiResponse(responseCode = "404", description = "Informazioni non trovate"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/info",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<RepartoDto>> getInfoReparto(@ParameterObject RicercaRepartoParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(repartoService.findReparto(params)));
    }

    @Operation(summary = "Eliminare un reparto",
            description = "Restituisce l'esito dell'operazione")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Eliminizazione andata a buon fine"),
            @ApiResponse(responseCode = "400", description = "Errore nell'eliminazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @DeleteMapping(value ="/delete",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> deleteReparto(@ParameterObject RicercaRepartoParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(repartoService.deleteReparto(params)));
    }

    @Operation(summary = "Modifica informazioni reparto",
            description = "Restituisce il reparto modificato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modifica andata a buon fine"),
            @ApiResponse(responseCode = "400", description = "Errore nella modifica"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PutMapping(value ="/modify",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<RepartoDto>> modificaRepartoInfo(@ParameterObject ModificaRepartoParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(repartoService.modificaReparto(params)));
    }

    //TODO Aggiungere /add
    @Operation(summary = "Modifica informazioni reparto",
            description = "Restituisce il reparto modificato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modifica andata a buon fine"),
            @ApiResponse(responseCode = "400", description = "Errore nella modifica"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/add",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<RepartoDto>> addReparto(@ParameterObject AddRepartoParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(repartoService.aggiuntaReparto(params)));
    }
}
