package com.bff.controller.msinfo;

import com.bff.constants.WebConstants;
import com.bff.dto.msinfo.ProfiloDto;
import com.bff.dto.msinfo.params.profilo.AddProfiloParams;
import com.bff.dto.msinfo.params.profilo.ModifyProfiloParams;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseDto;
import com.bff.service.msinfo.ProfiloService;
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
@RequestMapping(value = WebConstants.REST_CONTEX_BFF + WebConstants.REST_CONTEX_INFO+"/profilo")
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
    public ResponseEntity<GenericResponseDto<List<ProfiloDto>>> getAllProfilo(){
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
    public ResponseEntity<GenericResponseDto<ProfiloDto>> getInfoProfilo(@ParameterObject @PathVariable Integer id){
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
    public ResponseEntity<GenericResponseDto<ProfiloDto>> addProfilo(@ParameterObject AddProfiloParams params){
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
    public ResponseEntity<GenericResponseDto<ProfiloDto>> modifyProfilo(@ParameterObject ModifyProfiloParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(profiloService.modifcaProfilo(params)));
    }
}
