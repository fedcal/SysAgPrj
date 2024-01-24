package com.enciclopedia.controller;

import com.enciclopedia.constants.WebContstants;
import com.enciclopedia.dto.MedicinaleDto;
import com.enciclopedia.dto.params.medicinale.MedicinaleInfoParams;
import com.enciclopedia.dto.params.medicinale.MedicinaleParams;
import com.enciclopedia.esito.EsitoMessaggiRequestContextHolder;
import com.enciclopedia.esito.GenericResponseDto;
import com.enciclopedia.esito.Messaggio;
import com.enciclopedia.esito.costants.EsitoOperazioneEnum;
import com.enciclopedia.esito.costants.SeveritaMessaggioEnum;
import com.enciclopedia.exception.EsitoRuntimeException;
import com.enciclopedia.service.MedicinaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.websocket.server.PathParam;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value =WebContstants.REST_CONTEX_STRING +"/medicinale")
@Validated
public class MedicinaleController {

    @Autowired
    private MedicinaleService service;

    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @Operation(summary = "Ottenere la lista dei medicinali",
            description = "Restituisce la lista dei medicinali con le relative informazioni")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informazioni trovate"),
            @ApiResponse(responseCode = "404", description = "Informazioni non trovate"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MedicinaleDto>>> getAllMedicinali(){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getAllMedicinali");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.findAllMedicinali()));
    }

    @Operation(summary = "Ottenere le informazioni del medicinale",
            description = "Restituisce le informazioni del medicinale")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informazioni del medicinale"),
            @ApiResponse(responseCode = "404", description = "Informazioni non presenti"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MedicinaleDto>> getInfoMedicinale(MedicinaleInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getInfoMedicinale");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.findInfoMedicinale(params)));

    }

    @Operation(summary = "Eliminare un medicinale",
            description = "Restituisce l'esito dell'operazione")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Medicinale eliminato"),
            @ApiResponse(responseCode = "400", description = "Errore, medicinale non eliminato"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @DeleteMapping(value ="/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<String>> deleteMedicinaleId(@ParameterObject MedicinaleInfoParams params){
        boolean medicinaleEliminato = service.deleteMedicinale(params);
        if (medicinaleEliminato){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("deleteMedicinaleId");
            return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse("Medicinale eliminato"));
        }else {
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.setOperationId("getInfoMedicinale");
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR).codMsg("Nessun dato trovato").build());
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Aggiungere le informazioni di un nuovo medicinale",
            description = "Restituisce il medicinale aggiunto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informazioni aggiunte"),
            @ApiResponse(responseCode = "400", description = "Informazioni non aggiunte"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value ="/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MedicinaleDto>> addMedicinale(@ParameterObject MedicinaleParams params){
        MedicinaleDto response = service.addMedicinale(params);
        if(response == null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.setOperationId("getInfoMedicinale");
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR).codMsg("Nessun dato trovato").build());
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }else {
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("addMedicinale");
            return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(response));
        }
    }

    @Operation(summary = "Modificare le informazioni di un medicinale",
            description = "Restituisce il medicinale modificato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informazioni modificate"),
            @ApiResponse(responseCode = "400", description = "Informazioni non modificate"),
            @ApiResponse(responseCode = "500", description = "Errore di sistema")
    })
    @PostMapping(value = "/modify/{idMedicinale}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<MedicinaleDto>> modificaMedicinale(@ParameterObject @Schema(description = "Id medicinale")
                                                                                @PathParam("idMedicinale") Integer idMedicinale,
                                                                                @RequestBody @ParameterObject MedicinaleParams params){
        MedicinaleDto response = service.modificaMedicinalle(idMedicinale,params);
        if(response == null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.setOperationId("modificaMedicinale");
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR).codMsg("Nessun dato trovato").build());
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }else{
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("modificaMedicinale");
            return  ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(response));
        }

    }

}
