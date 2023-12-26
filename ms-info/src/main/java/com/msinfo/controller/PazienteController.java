package com.msinfo.controller;

import com.msinfo.constants.WebConstants;
import com.msinfo.dto.PazienteDto;
import com.msinfo.dto.params.paziente.AddPazienteParams;
import com.msinfo.dto.params.paziente.ModificaPazienteParams;
import com.msinfo.dto.params.paziente.SearchPazienteParams;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.GenericResponseDto;
import com.msinfo.service.PazienteService;
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
@RequestMapping(value = WebConstants.REST_CONTEX_STRING+"/paziente")
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
    @GetMapping(value ="/findAll",produces = MediaType.APPLICATION_JSON_VALUE)
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
    @GetMapping(value ="/searchPazienti",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<PazienteDto>>> search(@ParameterObject SearchPazienteParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(pazienteService.searchPaziente(params)));
    }

    @Operation(summary = "Eliminare un paziente",
            description = "Restituisce il risultato dell'operazione")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operazione andata a buon fine"),
            @ApiResponse(responseCode = "400", description = "Operazione non andata a buon fine"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @DeleteMapping(value ="/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> deletePaziente(@ParameterObject @PathVariable Integer id){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(pazienteService.deleteById(id)));
    }


    @Operation(summary = "Aggiungere un paziente",
            description = "Restituisce il dto del paziente aggiunto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operazione andata a buon fine"),
            @ApiResponse(responseCode = "400", description = "Operazione non andata a buon fine"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/aggiungi",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<PazienteDto>> addPaziente(@ParameterObject AddPazienteParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(pazienteService.addPaziente(params)));
    }

    @Operation(summary = "Modifica di un paziente",
            description = "Restituisce il dto del paziente modificato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operazione andata a buon fine"),
            @ApiResponse(responseCode = "400", description = "Operazione non andata a buon fine"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PutMapping(value ="/modify",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<PazienteDto>> modifyPaziente(@ParameterObject ModificaPazienteParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(pazienteService.modificaPaziente(params)));
    }


}
