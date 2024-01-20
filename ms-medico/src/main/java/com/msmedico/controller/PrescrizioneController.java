package com.msmedico.controller;

import com.msmedico.constants.WebConstants;
import com.msmedico.dto.params.prescrizione.operazione.PrescrizioneOperazioneAddParams;
import com.msmedico.dto.params.prescrizione.operazione.PrescrizioneOperazioneInfoParams;
import com.msmedico.dto.params.prescrizione.operazione.PrescrizioneOperazioneModifyParams;
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
import org.springframework.web.bind.annotation.*;

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
            operationId = "msMedicoPrescriviOperazioneInfo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elenco di tutte le prescrizioni delle operazioni"),
            @ApiResponse(responseCode = "404", description = "Nessun elenco disponibile"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/operazione-info",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<OperazionePrescrizioneDto>>> prescriviOperazioneInfo(@ParameterObject PrescrizioneOperazioneInfoParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(prescrizioneService.prescriviOperazioneInfo(params)));
    }

    @Operation(summary = "Prescrivere operazione",
            description = "Aggiungere una prescrizione di un'operazione",
            operationId = "msMedicoPrescriviOperazioneAdd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione operazione aggiunta"),
            @ApiResponse(responseCode = "404", description = "Nessuna operazione aggiunta"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/operazione-add",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<OperazionePrescrizioneDto>> prescriviOperazioneAdd(@ParameterObject PrescrizioneOperazioneAddParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(prescrizioneService.prescriviOperazioneAdd(params)));
    }
    @Operation(summary = "Prescrivere operazione",
            description = "Modificare una prescrizione di un'operazione",
            operationId = "msMedicoPrescriviOperazioneModify")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione operazione aggiunta"),
            @ApiResponse(responseCode = "404", description = "Nessuna operazione aggiunta"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/operazione-modify",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<OperazionePrescrizioneDto>> prescriviOperazioneModify(@ParameterObject PrescrizioneOperazioneModifyParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(prescrizioneService.prescriviOperazioneModify(params)));
    }
    @Operation(summary = "Eliminare una prescrizione di un'operazione",
            description = "Eliminare una prescrizione di un'operazione",
            operationId = "msMedicoPrescriviOperazioneDelete")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione operazione aggiunta"),
            @ApiResponse(responseCode = "404", description = "Nessuna operazione aggiunta"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @DeleteMapping(value ="/operazione-modify",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> prescriviOperazioneDelete(@ParameterObject Integer params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(prescrizioneService.prescriviOperazioneDelete(params)));
    }
}
