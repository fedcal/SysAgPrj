package com.enciclopedia.controller;

import com.enciclopedia.constants.WebContstants;
import com.enciclopedia.dto.SintomoMalattiaDto;
import com.enciclopedia.dto.output.SintomoMalattiaOutput;
import com.enciclopedia.dto.params.sintomomalattia.SintomoMalattiaAddParams;
import com.enciclopedia.dto.params.sintomomalattia.SintomoMalattiaChangeParams;
import com.enciclopedia.dto.params.sintomomalattia.SintomoMalattiaParams;
import com.enciclopedia.esito.EsitoMessaggiRequestContextHolder;
import com.enciclopedia.esito.GenericResponseDto;
import com.enciclopedia.esito.costants.EsitoOperazioneEnum;
import com.enciclopedia.service.SintomoMalattiaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = WebContstants.REST_CONTEX_STRING +"/sintomo-malattia")
@Validated
public class SintomoMalattiaController {

    @Autowired
    private SintomoMalattiaService service;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Operation(summary = "Ottenere tutte le relazioni tra sinotmi e malattie",
            description = "Restituisce tutte le relazioni in una lista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relazioni ottenute"),
            @ApiResponse(responseCode = "404", description = "Relazioni non ottenute"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<SintomoMalattiaDto>>> getAllSintomoMalattia(){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getAllSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.getAll()));
    }

    @Operation(summary = "Aggiungere una relazione tra un sintromo e una malattia",
            description = "Restituisce la relazzione aggiunta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relazione aggiunta"),
            @ApiResponse(responseCode = "400", description = "Relazione non aggiunta"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<SintomoMalattiaDto>> addSintomoMalattia(@ParameterObject SintomoMalattiaAddParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("addSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.addRelazione(params)));
    }

    @Operation(summary = "Ottenere una relazione tra sinotmi e malattie",
            description = "Restituisce la relazioni")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relazioni ottenute"),
            @ApiResponse(responseCode = "404", description = "Relazioni non ottenute"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<SintomoMalattiaOutput>> infoSintomoMalattia(@ParameterObject SintomoMalattiaParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("infoSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.infoRelazione(params)));
    }

    @Operation(summary = "Eliminare una relazione",
            description = "Restituisce il riusltato dell'operazione")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relazione eliminata"),
            @ApiResponse(responseCode = "400", description = "Relazione non eliminata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> deleteSintomoMalattia(@ParameterObject SintomoMalattiaParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("deleteSintomodeleteSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.deleteSintomoRelation(params)));
    }

    @Operation(summary = "Modificare una relazione",
            description = "Restituisce la relazione modificata")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relazione modificata"),
            @ApiResponse(responseCode = "400", description = "Relazione non modificata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PutMapping(value = "/modify", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<SintomoMalattiaDto>> modifySintomoMalattia(@ParameterObject SintomoMalattiaChangeParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("modifySintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.modifyRelazione(params)));
    }
}
