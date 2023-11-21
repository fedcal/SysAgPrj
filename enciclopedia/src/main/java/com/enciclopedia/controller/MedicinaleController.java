package com.enciclopedia.controller;

import com.enciclopedia.constants.WebContstants;
import com.enciclopedia.dto.MedicinaleDto;
import com.enciclopedia.dto.params.MedicinaleParams;
import com.enciclopedia.entity.Medicinale;
import com.enciclopedia.esito.Esito;
import com.enciclopedia.esito.EsitoMessaggiRequestContextHolder;
import com.enciclopedia.esito.GenericResponseDto;
import com.enciclopedia.esito.Messaggio;
import com.enciclopedia.esito.costants.EsitoOperazioneEnum;
import com.enciclopedia.esito.costants.SeveritaMessaggioEnum;
import com.enciclopedia.exception.EsitoRuntimeException;
import com.enciclopedia.service.MedicinaleService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
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
    @GetMapping("/info/{nomeMedicinale}")
    public ResponseEntity<GenericResponseDto<MedicinaleDto>> getInfoMedicinale(@PathParam("nomeMedicinale") String nomeMedicinale){
        MedicinaleDto response = service.findByNome(nomeMedicinale);
        if(response == null){
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.KO);
            esitoMessaggiRequestContextHolder.setOperationId("getInfoMedicinale");
            esitoMessaggiRequestContextHolder.getMessaggi().add(Messaggio.builder().severita(SeveritaMessaggioEnum.ERROR).codMsg("Nessun dato trovato").build());
            throw new EsitoRuntimeException(HttpStatus.BAD_REQUEST);
        }else {
            esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
            esitoMessaggiRequestContextHolder.setOperationId("getInfoMedicinale");
        }
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(response));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponseDto<String>> deleteMedicinaleId(@PathParam("id") Integer idMedicinale){
        boolean medicinaleEliminato = service.deleteMedicinale(idMedicinale);
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
    public ResponseEntity<GenericResponseDto<MedicinaleDto>> addMedicinale( MedicinaleParams params){
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
    public ResponseEntity<GenericResponseDto<MedicinaleDto>> modificaMedicinale(@PathParam("id") Integer idMedicinale,
                                                         MedicinaleParams params){
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
