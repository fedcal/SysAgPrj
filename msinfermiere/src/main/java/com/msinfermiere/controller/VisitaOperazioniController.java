package com.msinfermiere.controller;

import com.msinfermiere.constants.WebConstants;
import com.msinfermiere.dto.params.medicinaleoperazioni.SomministraMedicinaleParams;
import com.msinfermiere.dto.params.visiteoperazioni.FiltraVisitePrescrizioniParams;
import com.msinfermiere.dto.params.visiteoperazioni.FiltraVisiteSottoministrateInfermieriParams;
import com.msinfermiere.dto.params.visiteoperazioni.SomministraVisitaParams;
import com.msinfermiere.dto.relationentities.MedicinaleSottoministrazioneDto;
import com.msinfermiere.dto.relationentities.VisitaPrescrizioneDto;
import com.msinfermiere.dto.relationentities.VisitaSottoministrazioneInfermiereDto;
import com.msinfermiere.entity.relationentites.VisitaSottoministrazioneInfermiere;
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
            @ApiResponse(responseCode = "200", description = "Lista prescrizioni medicinali"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-prescrizioni",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<VisitaPrescrizioneDto>>> getAllVisitePrescrizioni (){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(visitaOperazioniService.getAllVisitePrescrizioni()));
    }

    @Operation(summary = "Lista prescrizioni visite",
            description = "Lista prescrizioni visite",
            operationId = "msInfermiereListaPrescrizioniVisiteFiltrata")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista prescrizioni medicinali"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-prescrizioni-filtrata",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<VisitaPrescrizioneDto>>> getAllVisitePrescrizioniFiltrate (FiltraVisitePrescrizioniParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(visitaOperazioniService.getVisitePrescrizioniFiltrata(params)));
    }

    @Operation(summary = "Lista prescrizioni visite",
            description = "Lista prescrizioni visite",
            operationId = "msInfermiereListaVisiteSottoministrateInfermierie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista prescrizioni medicinali"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-visite-sottoministrate",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<VisitaSottoministrazioneInfermiereDto>>> getAllVisiteSottoministrateInfermieri (){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(visitaOperazioniService.getAllVisiteSottoministrateInfermieri()));
    }

    @Operation(summary = "Lista prescrizioni visite filtrate",
            description = "Lista prescrizioni visite filtrate",
            operationId = "msInfermiereListaVisiteSottoministrateInfermierieFiltrate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista prescrizioni medicinali"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-visite-sottoministrate-filtrate",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<VisitaSottoministrazioneInfermiereDto>>> getAllVisiteSottoministrateInfermieriFiltrate (FiltraVisiteSottoministrateInfermieriParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(visitaOperazioniService.getAllVisiteSottoministrateInfermieriFiltrate(params)));
    }

    @Operation(summary = "Somministra visita da parte di un infermiere",
            description = "Somministra medicinale da parte di un infermiere",
            operationId = "msInfermiereSomministraVisitaInfermiere")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aggiunta sottoministrazione vista da infermiere "),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/somministrazione-visita-infermiere",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<VisitaSottoministrazioneInfermiereDto>> somministraVisita (@ParameterObject SomministraVisitaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(visitaOperazioniService.somministraVisita(params)));
    }
}
