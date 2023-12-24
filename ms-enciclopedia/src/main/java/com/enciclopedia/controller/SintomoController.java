package com.enciclopedia.controller;

import com.enciclopedia.constants.WebContstants;
import com.enciclopedia.dto.SintomoDto;
import com.enciclopedia.dto.params.sintomo.SintomoChangeParams;
import com.enciclopedia.dto.params.sintomo.SintomoInfoParams;
import com.enciclopedia.dto.params.sintomo.SintomoParams;
import com.enciclopedia.esito.EsitoMessaggiRequestContextHolder;
import com.enciclopedia.esito.GenericResponseDto;
import com.enciclopedia.esito.costants.EsitoOperazioneEnum;
import com.enciclopedia.service.SintomoService;
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
@RequestMapping( value = WebContstants.REST_CONTEX_STRING +"/sintomo")
@Validated
public class SintomoController {

    @Autowired
    private SintomoService service;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Operation(summary = "Ottenere le informazioni di tutti i sintomi",
            description = "Restituisce la lista di tutti i sintomi")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ottenute tutte le informazioni"),
            @ApiResponse(responseCode = "400", description = "Informazioni non ottenute"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<SintomoDto>>> getAll(){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getAllSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.getAll()));
    }

    @Operation(summary = "Aggiungere un nuovo sintomo",
            description = "Restituisce il sintomo aggiunto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sintomo aggiunto"),
            @ApiResponse(responseCode = "400", description = "Sintomo non aggiunto"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PutMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<SintomoDto>> addSintomo(@ParameterObject SintomoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("addSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.addSintomo(params)));
    }

    @Operation(summary = "Ottenere le informazioni di un sintomo",
            description = "Restituisce le infomazioni del sintomo selezionato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informazioni trovate"),
            @ApiResponse(responseCode = "404", description = "Informazioni non trovate"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<SintomoDto>> getInfoSintomo(@ParameterObject SintomoInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getInfoSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.getInfo(params)));
    }

    @Operation(summary = "Eliminare un sintomo",
            description = "Restituisce il riusltato dell'operazione")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sintomo eliminato"),
            @ApiResponse(responseCode = "400", description = "Sintomo non eliminato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> deleteSintomo(@ParameterObject SintomoInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("deleteSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.deleteSintomo(params)));
    }

    @Operation(summary = "Modificare le informazioni di un sintomo",
            description = "Restituisce il sintomo modificato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informazioni modificate"),
            @ApiResponse(responseCode = "400", description = "Informazioni non modificate"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PutMapping(value = "/modify", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<SintomoDto>> changeSintomo(@ParameterObject SintomoChangeParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("changeSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.changeSintomo(params)));
    }
}
