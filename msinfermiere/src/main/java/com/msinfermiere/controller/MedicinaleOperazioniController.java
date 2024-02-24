package com.msinfermiere.controller;

import com.msinfermiere.constants.WebConstants;
import com.msinfermiere.dto.params.medicinaleoperazioni.FiltraMedicinalePrescrizioniParams;
import com.msinfermiere.dto.params.medicinaleoperazioni.FiltraMedicinaliSottoministrazioneParams;
import com.msinfermiere.dto.params.medicinaleoperazioni.SomministraMedicinaleParams;
import com.msinfermiere.dto.relationentities.MedicinalePrescrizioneDto;
import com.msinfermiere.dto.relationentities.MedicinaleSottoministrazioneDto;
import com.msinfermiere.esito.EsitoMessaggiRequestContextHolder;
import com.msinfermiere.esito.GenericResponseDto;
import com.msinfermiere.service.MedicinaleOperazioniService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@RequestMapping(WebConstants.REST_CONTEX_STRING + "/operazioni-medicinali")
public class MedicinaleOperazioniController {
    @Autowired
    private MedicinaleOperazioniService medicinaleOperazioniService;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Operation(summary = "Lista prescrizioni medicinali",
            description = "Lista prescrizioni medicinali",
            operationId = "msInfermiereListaPrescrizioniMedicinali")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista prescrizioni medicinali"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-prescrizioni-medicinali",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MedicinalePrescrizioneDto>>> getAllMedicinalePrescrizioni (){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicinaleOperazioniService.getAllMedicinalePrescrizioni()));
    }

    @Operation(summary = "Lista prescrizioni medicinali",
            description = "Lista prescrizioni medicinali",
            operationId = "msInfermiereListaPrescrizioniMedicinali")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista prescrizioni medicinali"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-prescrizioni-medicin ali-filtrati",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MedicinalePrescrizioneDto>>> getPrescrizioniMedicinaliFiltrati (@ParameterObject FiltraMedicinalePrescrizioniParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicinaleOperazioniService.getPrescrizioniMedicinaliFiltrati(params)));
    }

    @Operation(summary = "Lista sottoministrazione medicinali infermiere",
            description = "Lista sottoministrazione medicinali infermiere",
            operationId = "msInfermiereListaSottoministrazioneMedicinaliInfermiere")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista prescrizioni medicinali"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-sottoministrazioni-medicinali-infermiere",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MedicinaleSottoministrazioneDto>>> getAllMedicinaleSottoministrazioni (){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicinaleOperazioniService.getAllMedicinaleSottoministrazioni()));
    }

    @Operation(summary = "Lista sottoministrazione medicinali filtrata",
            description = "Lista sottoministrazione medicinali filtrata",
            operationId = "msInfermiereListaSottoministrazioneMedicinaliFiltrata")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista prescrizioni medicinali"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-sottoministrazioni-medicinali-filtrati",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MedicinaleSottoministrazioneDto>>> getAllMedicinaleSottoministrazioniFiltrata (@ParameterObject FiltraMedicinaliSottoministrazioneParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicinaleOperazioniService.getAllMedicinaleSottoministrazioniFiltrata(params)));
    }

    @Operation(summary = "Somministra medicinale",
            description = "Somministra medicinale",
            operationId = "msInfermiereSomministraMedicinale")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aggiunta sottoministrazione medicinali"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/somministrazione-medicinale",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MedicinaleSottoministrazioneDto>> somministraMedicinale (@ParameterObject SomministraMedicinaleParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicinaleOperazioniService.somministraMedicinale(params)));
    }
}
