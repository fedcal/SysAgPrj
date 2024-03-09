package com.mspaziente.controller;

import com.mspaziente.constants.WebConstants;
import com.mspaziente.dto.CartellaClinicaDto;
import com.mspaziente.dto.DiagnosiDto;
import com.mspaziente.dto.output.CartellaClinicaOutputDto;
import com.mspaziente.dto.params.operazionispecifiche.AggiungiCartellaClinicaParams;
import com.mspaziente.dto.params.operazionispecifiche.AggiuntaDiagnosiParams;
import com.mspaziente.dto.params.operazionispecifiche.FindCartellaClinicaParams;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WebConstants.REST_CONTEX_STRING + "/paziente-operazioni-specifiche")
@Tag(name = "MsPazienteCartellaClinicaCreazioneController")
public class CartellaClinicaCreazioneController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private OperazioniSpecificheService operazioniSpecificheService;

    @Operation(summary = "Visualizza cartella clinica",
            description = "Visualizza cartella clinica",
            operationId = "msPazienteVisualizzaCartellaClinica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cartella clinica trovata"),
            @ApiResponse(responseCode = "404", description = "Cartella clinica non trovata"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/trova-cartella",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<CartellaClinicaOutputDto>> findCartellaClinica (@ParameterObject FindCartellaClinicaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.findCartellaClinica(params)));
    }

    @Operation(summary = "Aggiungi cartella clinica",
            description = "Aggiungi cartella clinica",
            operationId = "msPazienteAggiungiCartellaClinica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cartella clinica aggiunta"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/aggingi-cartella-clinica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<CartellaClinicaDto>> aggiungiCartellaClinica (@ParameterObject AggiungiCartellaClinicaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiCartellaClinica(params)));
    }

    //Aggiunta diagnosi
    @Operation(summary = "Aggiungi diagnosi",
            description = "Aggiungi diagnosi",
            operationId = "msPazienteDiagnosi")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Diagnosi aggiunta"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/aggingi-cartella-clinica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<DiagnosiDto>> aggiungiDiagnosi (@ParameterObject AggiuntaDiagnosiParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiDiagnosi(params)));
    }
    //aggiuta malattia

    //aggiunta medicinale cartella

    //aggiunta medicinale prescrizione

    //aggiunta medicinale sottoministrazione

    // aggiunta operazione cartella

    //aggiunta operazione prescrizione

    //aggiunta visita medica cartella

    //aggiunta visita prescrizione

    //aggiunta visita sottoministrazione infermiere

    //aggiungi visita sottoministrazione medico


}
