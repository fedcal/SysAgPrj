package com.bff.controller.msinfo;

import com.bff.constants.WebConstants;
import com.bff.dto.msinfo.InfermiereDto;
import com.bff.dto.msinfo.params.infermieri.AddInfermiereParams;
import com.bff.dto.msinfo.params.infermieri.FindInfermiereParams;
import com.bff.dto.msinfo.params.infermieri.ModifyInfermiereParams;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseDto;
import com.bff.service.msinfo.InfermieriService;
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
@RequestMapping(value = WebConstants.REST_CONTEX_BFF + WebConstants.REST_CONTEX_INFO+"/infermieri")
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
    public ResponseEntity<GenericResponseDto<List<InfermiereDto>>> getAllInfermiere(){
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
            description = "Restituisce il risultato dell'operazione")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Infermiere eliminato"),
            @ApiResponse(responseCode = "400", description = "Infermiere non eliminato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @DeleteMapping(value ="/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> deleteInfermiere(@ParameterObject @PathVariable Integer id){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(infermieriService.deleteInfermiere(id)));
    }

    @Operation(summary = "Modifica di un infermiere",
            description = "Restituisce l'infermiere modificato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Infermiere modificato"),
            @ApiResponse(responseCode = "400", description = "Infermiere non modificato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PutMapping(value ="/modify",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<InfermiereDto>> modifyInfermiere(@ParameterObject ModifyInfermiereParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(infermieriService.modifyInfermiere(params)));
    }

    @Operation(summary = "Aggiunta di un infermiere",
            description = "Restituisce l'infermiere aggiunto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Infermiere aggiunto"),
            @ApiResponse(responseCode = "404", description = "Infermiere non aggiunto"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/add",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<InfermiereDto>> addInfermiere(@ParameterObject AddInfermiereParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(infermieriService.addInfermiere(params)));
    }
}
