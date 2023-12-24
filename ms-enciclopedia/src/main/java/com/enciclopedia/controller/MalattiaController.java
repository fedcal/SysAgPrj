package com.enciclopedia.controller;

import com.enciclopedia.constants.WebContstants;
import com.enciclopedia.dto.MalattiaDto;
import com.enciclopedia.dto.params.malattia.MalattiaChangeInfoParams;
import com.enciclopedia.dto.params.malattia.MalattiaInfoParams;
import com.enciclopedia.dto.params.malattia.MalattiaParams;
import com.enciclopedia.esito.EsitoMessaggiRequestContextHolder;
import com.enciclopedia.esito.GenericResponseDto;
import com.enciclopedia.esito.costants.EsitoOperazioneEnum;
import com.enciclopedia.service.MalattiaService;
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
@RequestMapping(value = WebContstants.REST_CONTEX_STRING +"/malattia")
@Validated
public class MalattiaController {

    @Autowired
    private MalattiaService service;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Operation(summary = "Recuperare le informazioni di tutte le malattie",
            description = "Restituisce le informazioni di tutte le malattie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recupero informazioni andato a buon fine"),
            @ApiResponse(responseCode = "404", description = "Informazioni non trovate"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MalattiaDto>>> getAllMalattie(){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getAllMalattie");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.findAllMalattie()));
    }

    @Operation(summary = "Recuperare le informazioni della malattia selezionata",
            description = "Restituisce le informazioni della malattia selezionata")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recupero informazioni andato a buon fine"),
            @ApiResponse(responseCode = "404", description = "Informazioni non trovate"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MalattiaDto>> getMalattiaInfo(@ParameterObject MalattiaInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getMalattiaInfo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.findMalattiaInfo(params)));
    }

    @Operation(summary = "Aggiungere le informazioni di una nuova malattia",
            description = "Restituisce la malattia aggiunta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informazioni aggiunte"),
            @ApiResponse(responseCode = "400", description = "Informazioni non aggiunte"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MalattiaDto>> addMalattia(@ParameterObject MalattiaParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("addMalattia");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.addMalattia(params)));
    }

    @Operation(summary = "Modificare le informazioni di una malattia",
            description = "Restituisce le informazioni modificate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informazioni modificate correttamente"),
            @ApiResponse(responseCode = "400", description = "Informazioni non modificate"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PutMapping(value = "/change-info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MalattiaDto>> changeInfoMalattia(@ParameterObject MalattiaChangeInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("changeInfoMalattia");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.changeInfoMalattia(params)));

    }

    @Operation(summary = "Elimina una malattia",
            description = "Restituisce l'esito della cancellazione")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Restituisce l'esito dell'operazione"),
            @ApiResponse(responseCode = "400", description = "Operazione non andata a buon fine"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> deleteMalattia(@ParameterObject MalattiaInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("deleteMalattia");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.deleteMalattia(params)));
    }
}
