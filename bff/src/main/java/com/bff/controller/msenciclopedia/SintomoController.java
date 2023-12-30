package com.bff.controller.msenciclopedia;

import com.bff.constants.WebContstants;
import com.bff.dto.msenciclopedia.SintomoDto;
import com.bff.dto.msenciclopedia.params.sintomo.SintomoChangeParams;
import com.bff.dto.msenciclopedia.params.sintomo.SintomoInfoParams;
import com.bff.dto.msenciclopedia.params.sintomo.SintomoParams;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseDto;
import com.bff.service.msenciclopedia.SintomoService;
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
@RequestMapping(value = WebContstants.REST_CONTEX_BFF + WebContstants.REST_CONTEX_ENCICLOPEDIA+"/sintomo")
public class SintomoController {

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private SintomoService sintomoService;

    @Operation(summary = "Ottenere le informazioni di tutti i sintomi",
            description = "Restituisce la lista di tutti i sintomi")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ottenute tutte le informazioni"),
            @ApiResponse(responseCode = "400", description = "Informazioni non ottenute"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<SintomoDto>>> getAll(){
        esitoMessaggiRequestContextHolder.setOperationId("getAllSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(sintomoService.getAll()));
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
        esitoMessaggiRequestContextHolder.setOperationId("addSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(sintomoService.addSintomo(params)));
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
        esitoMessaggiRequestContextHolder.setOperationId("getInfoSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(sintomoService.getInfo(params)));
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
        esitoMessaggiRequestContextHolder.setOperationId("deleteSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(sintomoService.deleteSintomo(params)));
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
        esitoMessaggiRequestContextHolder.setOperationId("changeSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(sintomoService.changeSintomo(params)));
    }
}
