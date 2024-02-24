package com.bff.controller.msinfo;

import com.bff.constants.WebConstants;
import com.bff.dto.msinfo.RepartoDto;
import com.bff.dto.msinfo.params.reparto.AddRepartoParams;
import com.bff.dto.msinfo.params.reparto.ModificaRepartoParams;
import com.bff.dto.msinfo.params.reparto.RicercaRepartoParams;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseDto;
import com.bff.service.msinfo.RepartoService;
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
@RequestMapping(value = WebConstants.REST_CONTEX_BFF + WebConstants.REST_CONTEX_INFO+"/reparto")
@Tag(name = "Microservizio info", description = "ms-info")
public class RepartoController {
    @Autowired
    private RepartoService repartoService;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

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
