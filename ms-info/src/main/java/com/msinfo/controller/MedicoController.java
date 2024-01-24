package com.msinfo.controller;

import com.msinfo.constants.WebConstants;
import com.msinfo.dto.MedicoDto;
import com.msinfo.dto.params.medico.AddMedicoParams;
import com.msinfo.dto.params.medico.FindMedicoParams;
import com.msinfo.dto.params.medico.ModifyMedicoParams;
import com.msinfo.esito.EsitoMessaggiRequestContextHolder;
import com.msinfo.esito.GenericResponseDto;
import com.msinfo.service.MedicoService;
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
@RequestMapping(value = WebConstants.REST_CONTEX_STRING+"/medico")
public class MedicoController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private MedicoService medicoService;

    @Operation(summary = "Elenco di tutti i medici",
            description = "Restituisce una lista di InfermiereDto che racchiude tutte le informazioni relaitive ai medici")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elenco di tutti i medici"),
            @ApiResponse(responseCode = "404", description = "Nessun elenco disponibile"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/findAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MedicoDto>>> getAllMedico(){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicoService.findAll()));
    }

    @Operation(summary = "Filtraggio dei medici",
            description = "Restituisce una lista di MediciDto seguendo i filtri")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elenco di tutti i medici"),
            @ApiResponse(responseCode = "404", description = "Nessun elenco disponibile"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/find",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MedicoDto>>> findMedico(@ParameterObject FindMedicoParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicoService.findMedico(params)));
    }

    @Operation(summary = "Eliminare un medico",
            description = "Restituisce l'esito dell'operazione")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medico eliminato"),
            @ApiResponse(responseCode = "400", description = "Medico non eliminato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @DeleteMapping(value ="/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> deleteMedico(@ParameterObject @PathVariable Integer id){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicoService.deleteMedico(id)));
    }

    @Operation(summary = "Modifica di un medico",
            description = "Restituisce il medico modificato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medico modificato"),
            @ApiResponse(responseCode = "400", description = "Medico non modificato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PutMapping(value ="/modify",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MedicoDto>> modifyMedico(@ParameterObject ModifyMedicoParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicoService.modifyMedico(params)));
    }

    @Operation(summary = "Aggiungere un medico",
            description = "Restituisce il medico aggiunto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medico aggiunto"),
            @ApiResponse(responseCode = "400", description = "Medico non aggiunto"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/add",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MedicoDto>> addMedico(@ParameterObject AddMedicoParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicoService.addMedico(params)));
    }
}
