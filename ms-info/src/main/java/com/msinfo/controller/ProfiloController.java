package com.msinfo.controller;

import com.msinfo.constants.WebConstants;
import com.msinfo.dto.ProfiloDto;
import com.msinfo.dto.params.profilo.ProfiloAggiornamentoParams;
import com.msinfo.dto.params.profilo.ProfiloAggiuntaParams;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.GenericResponseDto;
import com.msinfo.service.ProfiloService;
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
@RequestMapping(value = WebConstants.REST_CONTEX_STRING+"/profilo")
public class ProfiloController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private ProfiloService profiloService;

    @Operation(summary = "Recupero lista profili disponibili",
               description = "Restituisce una lista di profili disponibili")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ricerca andata a buon fine"),
            @ApiResponse(responseCode = "404", description = "Ricerca non andata a buon fine"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<ProfiloDto>>> getAll(){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(profiloService.getAll()));
    }

    @Operation(summary = "Recupero info profilo disponibile",
            description = "Restituisce le info di un profilo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ricerca andata a buon fine"),
            @ApiResponse(responseCode = "404", description = "Ricerca non andata a buon fine"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/getProfilo/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<ProfiloDto>> getInfo(@ParameterObject @PathVariable Integer id){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(profiloService.getInfo(id)));
    }
    @Operation(summary = "Aggiunta profilo",
            description = "Restituisce il profilo inserito")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operazione andata a buon fine"),
            @ApiResponse(responseCode = "404", description = "Operazione non andata a buon fine"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/add",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<ProfiloDto>> addProfilo(@ParameterObject @PathVariable ProfiloAggiuntaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(profiloService.aggiuntaProfilo(params)));
    }


    @Operation(summary = "Aggiunta profilo",
            description = "Restituisce il profilo mdoficato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operazione andata a buon fine"),
            @ApiResponse(responseCode = "404", description = "Operazione non andata a buon fine"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PutMapping(value ="/modify",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<ProfiloDto>> modify(@ParameterObject @PathVariable ProfiloAggiornamentoParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(profiloService.modifcaProfilo(params)));
    }

}
