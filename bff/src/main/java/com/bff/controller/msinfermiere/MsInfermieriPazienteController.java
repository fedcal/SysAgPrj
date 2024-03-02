package com.bff.controller.msinfermiere;

import com.bff.constants.WebConstants;
import com.bff.dto.msinfermiere.params.PazienteFiltratiParams;
import com.bff.dto.msinfermiere.paziente.PazienteDto;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseDto;
import com.bff.service.msinfermiere.PazienteServiceInfermiere;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = WebConstants.REST_CONTEX_BFF + WebConstants.REST_CONTEX_INFERMIERI +"/pazienti")
@Tag(name = "Microservizio infermieri", description = "ms-infermieri")
public class MsInfermieriPazienteController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private PazienteServiceInfermiere pazienteService;

    @Operation(summary = "Lista pazienti",
            description = "Lista pazienti")
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
    public ResponseEntity<GenericResponseDto<List<PazienteDto>>> getPazientiFiltrati (PazienteFiltratiParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(pazienteService.getPazientiFiltrati(params)));
    }
}
