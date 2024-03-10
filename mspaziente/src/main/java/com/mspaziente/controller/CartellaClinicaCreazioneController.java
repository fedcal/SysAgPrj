package com.mspaziente.controller;

import com.mspaziente.constants.WebConstants;
import com.mspaziente.dto.CartellaClinicaDto;
import com.mspaziente.dto.DiagnosiDto;
import com.mspaziente.dto.operazione.RefertoOperazioneDto;
import com.mspaziente.dto.output.CartellaClinicaOutputDto;
import com.mspaziente.dto.params.creazionecartellaclinica.*;
import com.mspaziente.dto.relationentities.*;
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
    @GetMapping(value ="/aggiungi-cartella-clinica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<CartellaClinicaDto>> aggiungiCartellaClinica (@ParameterObject AggiungiCartellaClinicaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiCartellaClinica(params)));
    }

    //Aggiunta diagnosi
    @Operation(summary = "Aggiungi diagnosi a una cartella clinica",
            description = "Aggiungi diagnosi a una cartella clinica",
            operationId = "msPazienteAggiungiDiagnosiCartellaClinca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Diagnosi aggiunta"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/aggiungi-diagnosi-cartella-clinica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<DiagnosiDto>> aggiungiDiagnosi (@ParameterObject AggiuntaDiagnosiParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiDiagnosi(params)));
    }

    //Aggiunta malattia

    @Operation(summary = "Aggiungi malattia a una cartella clinica",
            description = "Aggiungi malattia a una cartella clinica",
            operationId = "msPazienteAggiungiMalattiaCartellaClinca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Malattia aggiunta"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/aggiungi-malattia-cartella-clinica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MalattiaCartellaDto>> aggiungiMalattia (@ParameterObject AggiungiMalattiaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiMalattia(params)));
    }

    //aggiunta medicinale cartella
    @Operation(summary = "Aggiungi medicinale a una cartella clinica",
            description = "Aggiungi medicinale a una cartella clinica",
            operationId = "msPazienteAggiungiMedicinaleCartellaClinca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicinale aggiunto"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/aggiungi-medicinale-cartella-clinica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MedicinaleCartellaDto>> aggiungiMedicinale (@ParameterObject AggiungiMedicinaleParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiMedicinale(params)));
    }

    //aggiunta medicinale prescrizione

    @Operation(summary = "Aggiungi prescrizione medicinale a una cartella clinica",
            description = "Aggiungi prescrizione medicinale a una cartella clinica",
            operationId = "msPazienteAggiungiPrescrizioneMedicinaleCartellaClinca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione medicinale aggiunto"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/aggiungi-prescrizione-medicinale-cartella-clinica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MedicinalePrescrizioneDto>> aggiungiPrescrizioneMedicinale (@ParameterObject AggiungiPrescrizioneMedicinaleParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiPrescrizioneMedicinale(params)));
    }

    //aggiunta medicinale sottoministrazione
    @Operation(summary = "Aggiungi prescrizione medicinale a una cartella clinica",
            description = "Aggiungi prescrizione medicinale a una cartella clinica",
            operationId = "msPazienteAggiungiPrescrizioneMedicinaleCartellaClinca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione medicinale aggiunto"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/aggiungi-medicinale-prescrizione-cartella-clinica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MedicinaleSottoministrazioneDto>> aggiungiMedicinalePrescrizione (@ParameterObject AggiungiMedicinaleSottoministrazioneParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiMedicinalePrescrizione(params)));
    }

    // aggiunta operazione cartella

    @Operation(summary = "Aggiungi operazione a una cartella clinica",
            description = "Aggiungi operazione a una cartella clinica",
            operationId = "msPazienteAggiungiOperazioneMedicinaleCartellaClinca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione medicinale aggiunto"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/aggiungi-operazione-cartella-clinica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<OperazioneCartellaDto>> aggiungiOperazione (@ParameterObject AggiungiOperazioneCartellaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiOperazione(params)));
    }

    // Aggiungi referto operazione
    @Operation(summary = "Aggiungi referto operazione",
            description = "Aggiungi referto operazione",
            operationId = "msPazienteAggiungiRefertoOperazione")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione medicinale aggiunto"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/aggiungi-referto-operazione",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<RefertoOperazioneDto>> aggiungiRefertoOperazione (@ParameterObject AggiungiRefertoOperazioneParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiRefertoOperazione(params)));
    }

    //aggiunta operazione prescrizione
    @Operation(summary = "Aggiungi operazione prescrizione a una cartella clinica",
            description = "Aggiungi operazione prescrizione a una cartella clinica",
            operationId = "msPazienteAggiuntaOperazionePrescrizioneCartellaClinca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione operazionne aggiunto"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/aggiungi-operazione-prescrizione-cartella-clinica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<OperazionePrescrizioneDto>> aggiungiOperazionePrescrizione (@ParameterObject AggiuntaOperazionePrescrizione params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiOperazionePrescrizione(params)));
    }
    //aggiunta visita medica cartella

    //aggiunta visita prescrizione

    //aggiunta visita sottoministrazione infermiere

    //aggiungi visita sottoministrazione medico


}
