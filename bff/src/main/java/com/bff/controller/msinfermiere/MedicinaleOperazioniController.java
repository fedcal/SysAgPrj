package com.bff.controller.msinfermiere;

import com.bff.constants.WebConstants;
import com.bff.dto.msinfermiere.params.medicinalioperazioni.FiltraMedicinalePrescrizioniParams;
import com.bff.dto.msinfermiere.params.medicinalioperazioni.FiltraMedicinaliSottoministrazioneParams;
import com.bff.dto.msinfermiere.params.medicinalioperazioni.SomministraMedicinaleParams;
import com.bff.dto.msinfermiere.relationentities.MedicinalePrescrizioneDto;
import com.bff.dto.msinfermiere.relationentities.MedicinaleSottoministrazioneDto;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseDto;
import com.bff.service.msinfermiere.MedicinaleOperazioniInfermiereService;
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
@RequestMapping(value = WebConstants.REST_CONTEX_BFF + WebConstants.REST_CONTEX_INFERMIERI+"/medicinali")
@Tag(name = "Microservizio infermieri", description = "ms-infermieri")
public class MedicinaleOperazioniController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private MedicinaleOperazioniInfermiereService medicinaleOperazioniInfermiereService;

    @Operation(summary = "Lista prescrizioni medicinali",
            description = "Lista prescrizioni medicinali")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista prescrizioni medicinali"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-prescrizioni-medicinali",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MedicinalePrescrizioneDto>>> getAllMedicinalePrescrizioni (){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicinaleOperazioniInfermiereService.getAllMedicinalePrescrizioni()));
    }

    @Operation(summary = "Lista prescrizioni medicinali",
            description = "Lista prescrizioni medicinali")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista prescrizioni medicinali"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-prescrizioni-medicinali-filtrati",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MedicinalePrescrizioneDto>>> getPrescrizioniMedicinaliFiltrati (@ParameterObject FiltraMedicinalePrescrizioniParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicinaleOperazioniInfermiereService.getPrescrizioniMedicinaliFiltrati(params)));
    }

    @Operation(summary = "Lista somministrazione medicinali infermiere",
            description = "Lista somministrazione medicinali infermiere")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista prescrizioni medicinali"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-sottoministrazioni-medicinali-infermiere",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MedicinaleSottoministrazioneDto>>> getAllMedicinaleSottoministrazioni (){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicinaleOperazioniInfermiereService.getAllMedicinaleSottoministrazioni()));
    }

    @Operation(summary = "Lista somministrazione medicinali filtrata",
            description = "Lista somministrazione medicinali filtrata")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista prescrizioni medicinali"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "404", description = "Lista non trovata"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/lista-sottoministrazioni-medicinali-filtrati",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MedicinaleSottoministrazioneDto>>> getAllMedicinaleSottoministrazioniFiltrata (@ParameterObject FiltraMedicinaliSottoministrazioneParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicinaleOperazioniInfermiereService.getAllMedicinaleSottoministrazioniFiltrata(params)));
    }

    @Operation(summary = "Somministra medicinale",
            description = "Somministra medicinale")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aggiunta somministrazione medicinali"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/somministrazione-medicinale",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MedicinaleSottoministrazioneDto>> somministraMedicinale (@ParameterObject SomministraMedicinaleParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicinaleOperazioniInfermiereService.somministraMedicinale(params)));
    }
}
