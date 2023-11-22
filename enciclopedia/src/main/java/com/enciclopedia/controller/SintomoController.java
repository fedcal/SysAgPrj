package com.enciclopedia.controller;

import com.enciclopedia.constants.WebContstants;
import com.enciclopedia.dto.SintomoDto;
import com.enciclopedia.dto.params.sintomo.SintomoChangeParams;
import com.enciclopedia.dto.params.sintomo.SintomoInfoParams;
import com.enciclopedia.dto.params.sintomo.SintomoParams;
import com.enciclopedia.esito.EsitoMessaggiRequestContextHolder;
import com.enciclopedia.esito.GenericResponseDto;
import com.enciclopedia.esito.costants.EsitoOperazioneEnum;
import com.enciclopedia.service.SintomoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( WebContstants.REST_CONTEX_STRING +"/sintomo")
@Validated
public class SintomoController {
    @Autowired
    private SintomoService service;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
    @GetMapping("/all")
    public ResponseEntity<GenericResponseDto<List<SintomoDto>>> getAll(){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getAllSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.getAll()));
    }
    @PutMapping("/add")
    public ResponseEntity<GenericResponseDto<SintomoDto>> addSintomo(SintomoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("addSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.addSintomo(params)));
    }

    @GetMapping("/info")
    public ResponseEntity<GenericResponseDto<SintomoDto>> getInfoSintomo(SintomoInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getInfoSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.getInfo(params)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<GenericResponseDto<String>> deleteSintomo(SintomoInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("deleteSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.deleteSintomo(params)));
    }
    @PutMapping("/change")
    public ResponseEntity<GenericResponseDto<SintomoDto>> changeSintomo(SintomoChangeParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("changeSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.changeSintomo(params)));
    }
}
