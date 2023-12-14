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
import jakarta.websocket.server.PathParam;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( WebContstants.REST_CONTEX_STRING +"/medicinale")
@Validated
public class MedicinaleController {
    @Autowired
    private MedicinaleService service;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @GetMapping("/all")
    public ResponseEntity<GenericResponseDto<List<MedicinaleDto>>> getAllMedicinali(){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getAllMedicinali");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.findAllMedicinali()));
    }
    @GetMapping("/info")
    public ResponseEntity<GenericResponseDto<MedicinaleDto>> getInfoMedicinale(MedicinaleInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getInfoMedicinale");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.findInfoMedicinale(params)));

    }

    @DeleteMapping("/delete")
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

    @PostMapping("/nuovo")
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

    @PostMapping("/modifica-info/{id}")
    public ResponseEntity<GenericResponseDto<MedicinaleDto>> modificaMedicinale(@ParameterObject @PathParam("id") Integer idMedicinale,
                                                                                @ParameterObject MedicinaleParams params){
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