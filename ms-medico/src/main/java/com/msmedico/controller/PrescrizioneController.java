package com.msmedico.controller;

import com.msmedico.constants.WebConstants;
import com.msmedico.dto.params.prescrizione.medicinale.PrescrizioneMedicinaleAddParams;
import com.msmedico.dto.params.prescrizione.medicinale.PrescrizioneMedicinaleInfoParams;
import com.msmedico.dto.params.prescrizione.medicinale.PrescrizioneMedicinaleModifyParams;
import com.msmedico.dto.params.prescrizione.operazione.PrescrizioneOperazioneAddParams;
import com.msmedico.dto.params.prescrizione.operazione.PrescrizioneOperazioneInfoParams;
import com.msmedico.dto.params.prescrizione.operazione.PrescrizioneOperazioneModifyParams;
import com.msmedico.dto.params.prescrizione.visita.PrescrizioneVisitaAddParams;
import com.msmedico.dto.params.prescrizione.visita.PrescrizioneVisitaInfoParams;
import com.msmedico.dto.params.prescrizione.visita.PrescrizioneVisitaModifyParams;
import com.msmedico.dto.relationentities.MedicinalePrescrizioneDto;
import com.msmedico.dto.relationentities.OperazionePrescrizioneDto;
import com.msmedico.dto.relationentities.VisitaPrescrizioneDto;
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
    @DeleteMapping(value ="/operazione-delete",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> prescriviOperazioneDelete(@ParameterObject Integer params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(prescrizioneService.prescriviOperazioneDelete(params)));
    }

    @Operation(summary = "Ottenere informazioni di una prescrizione di un medicinale",
            description = "Ottenere informazioni di una prescrizione di un medicinale",
            operationId = "msMedicoPrescriviMedicinaleInfo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione operazione aggiunta"),
            @ApiResponse(responseCode = "404", description = "Nessuna operazione aggiunta"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/medicinale-info",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MedicinalePrescrizioneDto>>> prescriviMedicinaleInfo(@ParameterObject PrescrizioneMedicinaleInfoParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(prescrizioneService.prescriviMedicinaleInfo(params)));
    }

    @Operation(summary = "Eliminare la prescrizione di un medicinale",
            description = "Eliminare la prescrizione di un medicinale",
            operationId = "msMedicoPrescriviMedicinaleDelete")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione operazione eliminata"),
            @ApiResponse(responseCode = "400", description = "Comportamento inaspettato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @DeleteMapping(value ="/medicinale-delete",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> prescriviMedicinaleDelete(@ParameterObject Integer params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(prescrizioneService.prescriviMedicinaleDelete(params)));
    }

    @Operation(summary = "Aggiungere la prescrizione di un medicinale",
            description = "Aggiungere la prescrizione di un medicinale",
            operationId = "msMedicoPrescriviMedicinaleAdd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione medicinale aggiunta"),
            @ApiResponse(responseCode = "404", description = "Nessuna prescrizione aggiunta"),
            @ApiResponse(responseCode = "400", description = "Comportamento inaspettato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/medicinale-add",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MedicinalePrescrizioneDto>> prescriviMedicinaleAdd(@ParameterObject PrescrizioneMedicinaleAddParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(prescrizioneService.prescriviMedicinaleAdd(params)));
    }

    @Operation(summary = "Modificare una prescrizione di un medicinale",
            description = "Eliminare una prescrizione di un medicinale",
            operationId = "msMedicoPrescriviMedicinaleModify")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione medicinale aggiunta"),
            @ApiResponse(responseCode = "404", description = "Nessun medicinale aggiunta"),
            @ApiResponse(responseCode = "400", description = "Comportamento inaspettato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/medicinale-modify",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MedicinalePrescrizioneDto>> prescriviMedicinaleModify(@ParameterObject PrescrizioneMedicinaleModifyParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(prescrizioneService.prescriviMedicinaleModify(params)));
    }

    @Operation(summary = "Informazione di una prescrizione di una visita",
            description = "Informazione di una prescrizione di una visita",
            operationId = "msMedicoprescriviVisitaInfo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione medicinale aggiunta"),
            @ApiResponse(responseCode = "404", description = "Nessun medicinale aggiunta"),
            @ApiResponse(responseCode = "400", description = "Comportamento inaspettato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/visita-info",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<VisitaPrescrizioneDto>>> prescriviVisitaInfo(@ParameterObject PrescrizioneVisitaInfoParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(prescrizioneService.prescriviVisitaInfo(params)));
    }

    @Operation(summary = "Modificare una prescrizione di un medicinale",
            description = "Eliminare una prescrizione di un medicinale",
            operationId = "msMedicoprescriviVisitaAdd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione medicinale aggiunta"),
            @ApiResponse(responseCode = "404", description = "Nessun medicinale aggiunta"),
            @ApiResponse(responseCode = "400", description = "Comportamento inaspettato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/visita-add",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<VisitaPrescrizioneDto>> prescriviVisitaAdd(@ParameterObject PrescrizioneVisitaAddParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(prescrizioneService.prescriviVisitaAdd(params)));
    }

    @Operation(summary = "Eliminare una prescrizione di una visita",
            description = "Eliminare una prescrizione di una visita",
            operationId = "msMedicoprescriviVisitaDelete")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione medicinale aggiunta"),
            @ApiResponse(responseCode = "404", description = "Nessun medicinale aggiunta"),
            @ApiResponse(responseCode = "400", description = "Comportamento inaspettato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/visita-delete",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> prescriviVisitaAdd(@ParameterObject Integer params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(prescrizioneService.prescriviVisitaDelete(params)));
    }

    @Operation(summary = "Eliminare una prescrizione di una visita",
            description = "Eliminare una prescrizione di una visita",
            operationId = "msMedicoprescriviVisitaModify")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione medicinale aggiunta"),
            @ApiResponse(responseCode = "404", description = "Nessun medicinale aggiunta"),
            @ApiResponse(responseCode = "400", description = "Comportamento inaspettato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/visita-modify",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<VisitaPrescrizioneDto>> prescriviVisitaAdd(@ParameterObject PrescrizioneVisitaModifyParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(prescrizioneService.prescriviVisitaModify(params)));
    }

}
