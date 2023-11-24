package com.enciclopedia.controller;

import com.enciclopedia.constants.WebContstants;
import com.enciclopedia.dto.SintomoMalattiaDto;
import com.enciclopedia.dto.params.sintomomalattia.SintomoMalattiaChangeParams;
import com.enciclopedia.dto.params.sintomomalattia.SintomoMalattiaParams;
import com.enciclopedia.esito.EsitoMessaggiRequestContextHolder;
import com.enciclopedia.esito.GenericResponseDto;
import com.enciclopedia.esito.costants.EsitoOperazioneEnum;
import com.enciclopedia.service.SintomoMalattiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( WebContstants.REST_CONTEX_STRING +"/sintomo-malattia")
@Validated
public class SintomoMalattiaController {
    @Autowired
    private SintomoMalattiaService service;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
    @GetMapping("/all")
    public ResponseEntity<GenericResponseDto<List<SintomoMalattiaDto>>> getAllSintomoMalattia(){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getAllSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.getAll()));
    }
    @PostMapping("/add")
    public ResponseEntity<GenericResponseDto<SintomoMalattiaDto>> addSintomo(SintomoMalattiaParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("addSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.addSintomo(params)));
    }
    @GetMapping("/info")
    public ResponseEntity<GenericResponseDto<SintomoMalattiaDto>> infoSintomo(SintomoMalattiaParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("infoSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.infoSintomo(params)));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<GenericResponseDto<String>> deleteSintomo(SintomoMalattiaParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("deleteSintomodeleteSintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.deleteSintomoRelation(params)));
    }

    @PutMapping("/modify")
    public ResponseEntity<GenericResponseDto<SintomoMalattiaDto>> modifySintomo(SintomoMalattiaChangeParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("modifySintomo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.modifySintomo(params)));
    }
}
