package com.msinfo.controller;

import com.msinfo.constants.WebConstants;
import com.msinfo.dto.PazienteDto;
import com.msinfo.dto.ProfiloDto;
import com.msinfo.dto.params.paziente.PazienteSearchParams;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.GenericResponseDto;
import com.msinfo.service.PazienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = WebConstants.REST_CONTEX_STRING+"/paziente")
public class PazienteController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private PazienteService pazienteService;

    @Operation(summary = "Elenco di tutti i pazienti",
            description = "Restituisce una lista di PazienteDto che racchiude tutti i pazienti")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elenco di tutti i pazienti"),
            @ApiResponse(responseCode = "404", description = "Nessun elenco disponibile"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value = "/findAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<PazienteDto>>> getAll(){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(pazienteService.findAll()));
    }

    @Operation(summary = "Ricerca di un paziente in base ai diversi parametri in input",
               description = "Restituisce una lista di PazienteDto che soddisfa i parametri di ricerca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ricerca andata a buon fine"),
            @ApiResponse(responseCode = "404", description = "Ricerca non andata a buon fine"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value = "/search",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<PazienteDto>>> search(@ParameterObject PazienteSearchParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(pazienteService.searchPaziente(params)));
    }


}
