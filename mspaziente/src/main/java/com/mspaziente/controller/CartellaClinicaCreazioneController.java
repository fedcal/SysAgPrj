package com.mspaziente.controller;

import com.mspaziente.constants.WebConstants;
import com.mspaziente.dto.CartellaClinicaDto;
import com.mspaziente.dto.DiagnosiDto;
import com.mspaziente.dto.operazione.RefertoOperazioneDto;
import com.mspaziente.dto.output.CartellaClinicaOutputDto;
import com.mspaziente.dto.params.creazionecartellaclinica.*;
import com.mspaziente.dto.relationentities.*;
import com.mspaziente.dto.visitamedica.RefertoVisitaMedicaDto;
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
            operationId = "msPazienteAggiungiOperazioneCartellaClinca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operazione aggiunta"),
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
            @ApiResponse(responseCode = "200", description = "Referto aggiunto"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/aggiungi-referto-operazione",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<RefertoOperazioneDto>> aggiungiRefertoOperazione (@ParameterObject AggiungiRefertoOperazioneParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiRefertoOperazione(params)));
    }

    //aggiunta operazione prescrizione
    @Operation(summary = "Aggiungi prescrizione operazione a una cartella clinica",
            description = "Aggiungi prescrizione operazione a una cartella clinica",
            operationId = "msPazienteAggiuntaPrescrizioneOperazioneCartellaClinca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione operazionne aggiunta"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/aggiungi-prescrizione-operazione-cartella-clinica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<OperazionePrescrizioneDto>> aggiungiOperazionePrescrizione (@ParameterObject AggiuntaOperazionePrescrizioneParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiOperazionePrescrizione(params)));
    }
    //aggiunta visita medica cartella
    @Operation(summary = "Aggiungi visita medica a una cartella clinica",
            description = "Aggiungi visita medica a una cartella clinica",
            operationId = "msPazienteAggiuntaVisitaMedicaCartellaClinca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Visita medica aggiunta"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/aggiungi-visita-medica-cartella-clinica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<VisitaMedicaCartellaDto>> aggiungiVisitaMedica (@ParameterObject AggiungiVisitaMedicaCartellaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiVisitaMedica(params)));
    }

    //Aggiunta referto visita medica
    @Operation(summary = "Aggiungi referto visita medica",
            description = "Aggiungi referto visita medica",
            operationId = "msPazienteAggiungiRefertoVisitaMedica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Referto visita medica aggiunto"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/aggiungi-referto-visita-medica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<RefertoVisitaMedicaDto>> aggiungiRefertoVisitaMedica (@ParameterObject AggiungiRefertoVisitaMedicaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiRefertoVisitaMedica(params)));
    }

    //aggiunta visita prescrizione
    @Operation(summary = "Aggiungi prescrizione visita medica a una cartella clinica",
            description = "Aggiungi prescrizione visita medica a una cartella clinica",
            operationId = "msPazienteAggiuntaPrescrizioneVisitaMedicaCartellaClinca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prescrizione visita aggiunta"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/aggiungi-prescrizione-visita-medica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<VisitaPrescrizioneDto>> aggiungiPrescrizioneVisita (@ParameterObject AggiungiVisitaPrescrizioneParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiPrescrizioneVisita(params)));
    }

    //aggiunta visita sottoministrazione infermiere
    @Operation(summary = "Aggiungi sottoministrazione visita da parte di un'infermiere a una cartella clinica",
            description = "Aggiungi sottoministrazione visita da parte di un'infermiere a una cartella clinica",
            operationId = "msPazienteAggiuntaVisitaSottoministrazioneInfermiereCartellaClinca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sottoministrazione visita da parte di un infermiere aggiunta"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/aggiungi-visita-sottoministrazione-infermiere",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<VisitaSottoministrazioneInfermiereDto>> aggiungiVisitaSottoministrazioneInfermiere (@ParameterObject AggiungiVisitaSottoministrazioneInfermiereParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiVisitaSottoministrazioneInfermiere(params)));
    }

    //aggiungi visita sottoministrazione medico
    @Operation(summary = "Aggiungi visita sottoministrazione da parte di un medico a una cartella clinica",
            description = "Aggiungi visita sottoministrazione da parte di un medico a una cartella clinica",
            operationId = "msPazienteAggiuntaVisitaSottoministrazioneMedicoCartellaClinca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sottoministrazione visita da parte di un medico aggiunta"),
            @ApiResponse(responseCode = "400", description = "Errore elaborazione"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/aggiungi-visita-sottoministrazione-medico",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<VisitaSottoministrazioneMedicoDto>> aggiungiVisitaSottoministrazioneMedico (@ParameterObject AggiungiVisitaSottoministrazioneMedicoParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(operazioniSpecificheService.aggiungiVisitaSottoministrazioneMedico(params)));
    }


}
