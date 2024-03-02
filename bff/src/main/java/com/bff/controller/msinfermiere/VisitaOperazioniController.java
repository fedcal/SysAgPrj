package com.bff.controller.msinfermiere;

import com.bff.constants.WebConstants;
import com.bff.dto.msinfermiere.params.visiteoperazioni.FiltraVisitePrescrizioniParams;
import com.bff.dto.msinfermiere.params.visiteoperazioni.FiltraVisiteSottoministrateInfermieriParams;
import com.bff.dto.msinfermiere.params.visiteoperazioni.SomministraVisitaParams;
import com.bff.dto.msinfermiere.relationentities.VisitaPrescrizioneDto;
import com.bff.dto.msinfermiere.relationentities.VisitaSottoministrazioneInfermiereDto;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseDto;
import com.bff.service.msinfermiere.MsInfermiereVisitaOperazioniService;
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
@RequestMapping(value = WebConstants.REST_CONTEX_BFF + WebConstants.REST_CONTEX_INFERMIERI+"/operazioni-visite")
@Tag(name = "Microservizio infermieri", description = "ms-infermieri")
public class VisitaOperazioniController {

    @Autowired
    private MsInfermiereVisitaOperazioniService visitaOperazioniService;

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
            operationId = "msInfermiereListaPrescrizioniVisite")
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
            operationId = "msInfermiereSomministraMedicinaleInfermiere")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aggiunta sottoministrazione vista da infermiere "),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/somministrazione-visita-infermiere",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<VisitaSottoministrazioneInfermiereDto>> somministraMedicinale (@ParameterObject SomministraVisitaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(visitaOperazioniService.somministraMedicinale(params)));
    }
}
