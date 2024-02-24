package com.bff.controller.msmedico;

import com.bff.constants.WebConstants;
import com.bff.dto.msmedico.params.visualizzastato.FindCartellaClinicaParams;
import com.bff.dto.msmedico.params.visualizzastato.FindOperazioneParams;
import com.bff.dto.msmedico.params.visualizzastato.FindStatoVisitaMedicaParams;
import com.bff.dto.msmedico.paziente.CartellaClinicaDto;
import com.bff.dto.msmedico.relationentities.OperazioneCartellaDto;
import com.bff.dto.msmedico.relationentities.VisitaMedicaCartellaDto;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseDto;
import com.bff.service.msmedico.VisualizzaStatoService;
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

import java.util.List;

@RestController
@RequestMapping(WebConstants.REST_CONTEX_BFF + WebConstants.REST_CONTEX_MEDICI + "/visualizza-stato")
@Tag(name = "Microservizio medico", description = "ms-medico")
public class VisualizzaStatoController {
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Autowired
    private VisualizzaStatoService visualizzaStatoService;
    @Operation(summary = "Visualizzazione stato visite mediche filtrate per diversi campi",
            description = "Restituisce una lista di VisitaMedicaCartellaDto che racchiude tutte le informazioni relaitive " +
                    "alle visite mediche",
            operationId = "msMedicoGetStatoVisita")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elenco di tutti i medici"),
            @ApiResponse(responseCode = "404", description = "Nessun elenco disponibile"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/visita-medica",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<VisitaMedicaCartellaDto>>> getStatoVisita(@ParameterObject FindStatoVisitaMedicaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(visualizzaStatoService.statoVisita(params)));
    }
    @Operation(summary = "Visualizzazione stato visite mediche filtrate per diversi campi",
            description = "Restituisce una lista di CartellaClinicaDto che racchiude tutte le informazioni relaitive " +
                    "alle cartelle cliniche",
            operationId = "msMedicoGetCartelleCliniche")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elenco di tutti i medici"),
            @ApiResponse(responseCode = "404", description = "Nessun elenco disponibile"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/cartelle-cliniche",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<CartellaClinicaDto>>> getCartelleCliniche(@ParameterObject FindCartellaClinicaParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(visualizzaStatoService.statoCartellaClinica(params)));
    }

    @Operation(summary = "Visualizzazione stato delle operazioni filtrate per diversi campi",
            description = "Restituisce una lista di VisitaMedicaCartellaDto che racchiude tutte le informazioni relaitive " +
                    "alle operazioni mediche",
            operationId = "msMedicoGetStatoOperazione")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Elenco di tutte le operazioni filtrate"),
            @ApiResponse(responseCode = "404", description = "Nessun elenco disponibile"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value ="/operazione",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<OperazioneCartellaDto>>> getStatoOperazione(@ParameterObject FindOperazioneParams params){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(visualizzaStatoService.operazioneCartella(params)));
    }
}
