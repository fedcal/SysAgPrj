package com.bff.controller.msinfo;

import com.bff.constants.WebContstants;
import com.bff.dto.msinfo.SpecialistaDto;
import com.bff.dto.msinfo.params.specialista.AddSpecialistaParams;
import com.bff.dto.msinfo.params.specialista.FindSpecialistaParams;
import com.bff.dto.msinfo.params.specialista.ModifySpecialistaParams;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseDto;
import com.bff.service.msinfo.SpecialistaService;
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
@RequestMapping(value = WebContstants.REST_CONTEX_BFF + WebContstants.REST_CONTEX_INFO+"/specialista")
public class SpecialistaController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private SpecialistaService specialistaService;

    @Operation(summary = "Elenco di tutti i medici",
            description = "Restituisce una lista di InfermiereDto che racchiude tutte le informazioni relaitive ai medici")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elenco di tutti i medici"),
            @ApiResponse(responseCode = "404", description = "Nessun elenco disponibile"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/findAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<SpecialistaDto>>> getAllSpecialista(){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(specialistaService.findAll()));
    }

    @Operation(summary = "Filtraggio dei medici",
            description = "Restituisce una lista di MediciDto seguendo i filtri")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elenco di tutti gli infermieri"),
            @ApiResponse(responseCode = "404", description = "Nessun elenco disponibile"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/find",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<SpecialistaDto>>> findSpecialista(@ParameterObject FindSpecialistaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(specialistaService.findSpecialista(params)));
    }

    @Operation(summary = "Eliminare un medico",
            description = "Restituisce l'esito dell'operazione")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medico eliminato"),
            @ApiResponse(responseCode = "400", description = "Medico non eliminato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @DeleteMapping(value ="/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> deleteSpecialista(@ParameterObject @PathVariable Integer id){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(specialistaService.deleteSpecialista(id)));
    }

    @Operation(summary = "Modifica di un medico",
            description = "Restituisce il medico modificato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medico modificato"),
            @ApiResponse(responseCode = "400", description = "Medico non modificato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PutMapping(value ="/modify",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<SpecialistaDto>> modifySpecialista(@ParameterObject ModifySpecialistaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(specialistaService.modifySpecialista(params)));
    }

    @Operation(summary = "Aggiungere un medico",
            description = "Restituisce il medico aggiunto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medico aggiunto"),
            @ApiResponse(responseCode = "400", description = "Medico non aggiunto"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/add",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<SpecialistaDto>> addSpecialista(@ParameterObject AddSpecialistaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(specialistaService.addSpecialista(params)));
    }
}
