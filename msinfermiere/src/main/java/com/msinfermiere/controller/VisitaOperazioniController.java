package com.msinfermiere.controller;

import com.msinfermiere.constants.WebConstants;
import com.msinfermiere.dto.params.visiteoperazioni.FiltraVisitePrescrizioniParams;
import com.msinfermiere.dto.params.visiteoperazioni.FiltraVisiteSottoministrateInfermieriParams;
import com.msinfermiere.dto.params.visiteoperazioni.SomministraVisitaParams;
import com.msinfermiere.dto.relationentities.VisitaEffettuataInfermiereDto;
import com.msinfermiere.dto.relationentities.VisitaPrescrizioneDto;
import com.msinfermiere.esito.EsitoMessaggiRequestContextHolder;
import com.msinfermiere.esito.GenericResponseDto;
import com.msinfermiere.service.VisitaOperazioniService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(WebConstants.REST_CONTEX_STRING + "/operazioni-visite")
@Tag(name ="MsInfermieriVisitaOperazioniController")
public class VisitaOperazioniController {
    @Autowired
    private VisitaOperazioniService visitaOperazioniService;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Operation(summary = "Lista prescrizioni visite",
            description = "Lista prescrizioni visite",
            operationId = "msInfermiereListaPrescrizioniVisite")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista prescrizioni visite"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-prescrizioni",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<VisitaPrescrizioneDto>>> getAllVisitePrescrizioni (){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(visitaOperazioniService.getAllVisitePrescrizioni()));
    }

    @Operation(summary = "Lista prescrizioni visite filtrata",
            description = "Lista prescrizioni visite filtrata",
            operationId = "msInfermiereListaPrescrizioniVisiteFiltrata")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista prescrizioni visite filtrate"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-prescrizioni-filtrata",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<VisitaPrescrizioneDto>>> getAllVisitePrescrizioniFiltrate (@ParameterObject FiltraVisitePrescrizioniParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(visitaOperazioniService.getVisitePrescrizioniFiltrata(params)));
    }

    @Operation(summary = "Lista visite effettuate",
            description = "Lista visite effettuate",
            operationId = "msInfermiereListaVisiteEffettuateInfermierie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista visite effettuate"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-visite-effettuate",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<VisitaEffettuataInfermiereDto>>> getAllVisiteEffettuateInfermieri (){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(visitaOperazioniService.getAllVisiteEffettuateInfermieri()));
    }

    @Operation(summary = "Lista visite effettuate filtrata",
            description = "Lista visite effettuate filtrata",
            operationId = "msInfermiereListaVisiteEffettuateInfermierieFiltrata")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista visite effettuate filtrata"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-visite-effettuate-filtrate",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<VisitaEffettuataInfermiereDto>>> getAllVisiteEffettuateInfermieriFiltrate (@ParameterObject FiltraVisiteSottoministrateInfermieriParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(visitaOperazioniService.getAllVisiteEffettuateInfermieriFiltrate(params)));
    }

    @Operation(summary = "Effettua visita da parte di un infermiere",
            description = "Effettua visita da parte di un infermiere",
            operationId = "msInfermiereEffettuaVisitaInfermiere")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aggiunta vista effettuata da parte di un infermiere "),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/effettua-visita-infermiere",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<VisitaEffettuataInfermiereDto>> effettuaVisita (@ParameterObject SomministraVisitaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(visitaOperazioniService.effettuaVisita(params)));
    }
}
