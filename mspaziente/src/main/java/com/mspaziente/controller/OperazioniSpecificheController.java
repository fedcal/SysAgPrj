package com.mspaziente.controller;

import com.mspaziente.constants.WebConstants;
import com.mspaziente.dto.CartellaClinicaDto;
import com.mspaziente.dto.PazienteDto;
import com.mspaziente.dto.output.CartellaClinicaOutputDto;
import com.mspaziente.dto.params.operazionispecifiche.FindCartellaClinica;
import com.mspaziente.dto.relationentities.MalattiaCartellaDto;
import com.mspaziente.entity.relationentities.MalattiaCartella;
import com.mspaziente.entity.relationentities.MedicinalePrescrizione;
import com.mspaziente.esito.EsitoMessaggiRequestContextHolder;
import com.mspaziente.esito.GenericResponseDto;
import com.mspaziente.service.OperazioniSpecificheService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(WebConstants.REST_CONTEX_STRING + "/paziente-operazioni-specifiche")
@Tag(name = "MsPazienteOperazioniSpecificheController")
public class OperazioniSpecificheController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private OperazioniSpecificheService operazioniSpecificheService;

    @Operation(summary = "Visualizza cartella clinica",
            description = "Visualizza cartella clinica",
            operationId = "msPazienteCartellaClinica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cartella clinica trovata"),
            @ApiResponse(responseCode = "404", description = "Cartella clinica non trovata"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/trova-cartella",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<CartellaClinicaOutputDto>> findCartellaClinica (@ParameterObject FindCartellaClinica params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.findCartellaClinica(params)));
    }

    @GetMapping(value ="/test",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MedicinalePrescrizione>>> test (){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.test()));
    }
}
