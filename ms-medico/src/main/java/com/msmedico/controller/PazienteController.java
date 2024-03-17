package com.msmedico.controller;

import com.msmedico.constants.WebConstants;
import com.msmedico.dto.output.CartellaClinicaOutputDto;
import com.msmedico.dto.params.paziente.FindCartellaClinicaPazienteParams;
import com.msmedico.dto.params.paziente.FindPazienteParams;
import com.msmedico.dto.paziente.PazienteDto;
import com.msmedico.esito.EsitoMessaggiRequestContextHolder;
import com.msmedico.esito.GenericResponseDto;
import com.msmedico.service.PazienteService;
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
@RequestMapping(WebConstants.REST_CONTEX_STRING + "/pazienti")
@Tag(name ="MsMedicoPazienteController")
public class PazienteController {

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
    @Autowired
    private PazienteService pazienteService;

    @Operation(summary = "Lista pazienti",
            description = "Lista pazienti",
            operationId = "msMedicoListaPazienti")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista trovata"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata trovata"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-pazienti",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<PazienteDto>>> findAllPazienti (){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(pazienteService.getAllPazienti()));
    }

    @Operation(summary = "Lista pazienti filtrata",
            description = "Lista pazienti filtrata",
            operationId = "msMedicoInfoPazienti")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista trovata"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata trovata"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/info-paziente",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<PazienteDto>>> findInfoPazienti (@ParameterObject FindPazienteParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(pazienteService.findInfoPazienti(params)));
    }

    @Operation(summary = "Visualizza cartella clinica",
            description = "Visualizza cartella clinica",
            operationId = "msMedicoVisualizzaCartellaClinica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cartella clinica trovata"),
            @ApiResponse(responseCode = "404", description = "Cartella clinica non trovata"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/trova-cartella",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<CartellaClinicaOutputDto>> findCartellaClinica (@ParameterObject FindCartellaClinicaPazienteParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(pazienteService.findCartellaClinica(params)));
    }
}
