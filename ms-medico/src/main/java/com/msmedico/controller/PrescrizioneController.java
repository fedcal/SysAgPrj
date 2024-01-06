package com.msmedico.controller;

import com.msmedico.constants.WebConstants;
import com.msmedico.dto.params.visualizzastato.FindCartellaClinicaParams;
import com.msmedico.dto.paziente.CartellaClinicaDto;
import com.msmedico.dto.relationentities.OperazionePrescrizioneDto;
import com.msmedico.esito.EsitoMessaggiRequestContextHolder;
import com.msmedico.esito.GenericResponseDto;
import com.msmedico.service.PrescrizioneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(WebConstants.REST_CONTEX_STRING + "/prescrizione")
public class PrescrizioneController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private PrescrizioneService prescrizioneService;

    @Operation(summary = "Visualizzazione stato visite mediche filtrate per diversi campi",
            description = "Restituisce una lista di CartellaClinicaDto che racchiude tutte le informazioni relaitive " +
                    "alle cartelle cliniche",
            operationId = "msMedicoPrescriviOperazione")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elenco di tutti i medici"),
            @ApiResponse(responseCode = "404", description = "Nessun elenco disponibile"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/cartelle-cliniche",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<OperazionePrescrizioneDto>>> prescriviOperazione(@ParameterObject FindCartellaClinicaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(prescrizioneService.prescriviOperazione(params)));
    }
}
