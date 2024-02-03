package com.bff.controller.msenciclopedia;

import com.bff.constants.WebConstants;
import com.bff.dto.msenciclopedia.SintomoMalattiaDto;
import com.bff.dto.msenciclopedia.params.sintomomalattia.SintomoMalattiaChangeParams;
import com.bff.dto.msenciclopedia.params.sintomomalattia.SintomoMalattiaParams;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseDto;
import com.bff.esito.costants.EsitoOperazioneEnum;
import com.bff.service.msenciclopedia.SintomoMalattiaService;
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
@RequestMapping(value = WebConstants.REST_CONTEX_BFF + WebConstants.REST_CONTEX_ENCICLOPEDIA+"/sintomo-malattia")
public class SintomoMalattiaController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private SintomoMalattiaService sintomoMalattiaService;

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
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(sintomoMalattiaService.getAll()));
    }

    @Operation(summary = "Aggiungere una relazione tra un sintromo e una malattia",
            description = "Restituisce la relazzione aggiunta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relazione aggiunta"),
            @ApiResponse(responseCode = "400", description = "Relazione non aggiunta"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<SintomoMalattiaDto>> addSintomo(@ParameterObject SintomoMalattiaParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("addSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(sintomoMalattiaService.addSintomo(params)));
    }

    @Operation(summary = "Ottenere una relazione tra sinotmi e malattie",
            description = "Restituisce la relazioni")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relazioni ottenute"),
            @ApiResponse(responseCode = "404", description = "Relazioni non ottenute"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<SintomoMalattiaDto>> infoSintomo(@ParameterObject SintomoMalattiaParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("infoSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(sintomoMalattiaService.infoSintomo(params)));
    }

    @Operation(summary = "Eliminare una relazione",
            description = "Restituisce il riusltato dell'operazione")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relazione eliminata"),
            @ApiResponse(responseCode = "400", description = "Relazione non eliminata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> deleteSintomo(@ParameterObject SintomoMalattiaParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("deleteSintomodeleteSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(sintomoMalattiaService.deleteSintomoRelation(params)));
    }

    @Operation(summary = "Modificare una relazione",
            description = "Restituisce la relazione modificata")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relazione modificata"),
            @ApiResponse(responseCode = "400", description = "Relazione non modificata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PutMapping(value = "/modify", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<SintomoMalattiaDto>> modifySintomo(@ParameterObject SintomoMalattiaChangeParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("modifySintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(sintomoMalattiaService.modifySintomo(params)));
    }
}
