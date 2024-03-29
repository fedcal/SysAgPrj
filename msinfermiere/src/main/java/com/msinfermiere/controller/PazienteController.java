package com.msinfermiere.controller;

import com.msinfermiere.constants.WebConstants;
import com.msinfermiere.dto.output.CartellaClinicaOutputDto;
import com.msinfermiere.dto.params.FindCartellaClinicaParams;
import com.msinfermiere.dto.params.PazienteFiltratiParams;
import com.msinfermiere.dto.paziente.PazienteDto;
import com.msinfermiere.dto.relationentities.VisitaPrescrizioneDto;
import com.msinfermiere.esito.EsitoMessaggiRequestContextHolder;
import com.msinfermiere.esito.GenericResponseDto;
import com.msinfermiere.service.PazienteService;
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
@RequestMapping(WebConstants.REST_CONTEX_STRING + "/paziente")
@Tag(name ="MsInfermieriPazienteController")
public class PazienteController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private PazienteService pazienteService;

    @Operation(summary = "Lista pazienti",
            description = "Lista pazienti",
            operationId = "msInfermiereListaPazienti")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista pazienti"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-pazienti",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<PazienteDto>>> getAllPazienti (){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(pazienteService.getAllPazienti()));
    }

    @Operation(summary = "Lista pazienti filtrati",
            description = "Lista pazienti filtrati",
            operationId = "msInfermiereListaPazientiFiltrati")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista pazienti filtrata"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-pazienti-filtrati",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<PazienteDto>>> getPazientiFiltrati (@ParameterObject PazienteFiltratiParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(pazienteService.getPazientiFiltrati(params)));
    }
    @Operation(summary = "Visualizza cartella clinica",
            description = "Visualizza cartella clinica",
            operationId = "msPazienteVisualizzaCartellaClinica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cartella clinica trovata"),
            @ApiResponse(responseCode = "404", description = "Cartella clinica non trovata"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/trova-cartella-clinica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<CartellaClinicaOutputDto>> findCartellaClinica (@ParameterObject FindCartellaClinicaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(pazienteService.findCartellaClinica(params)));
    }
}
