package com.enciclopedia.controller;

import com.enciclopedia.constants.WebContstants;
import com.enciclopedia.dto.MalattiaDto;
import com.enciclopedia.dto.params.MalattiaChangeInfoParams;
import com.enciclopedia.dto.params.MalattiaInfoParams;
import com.enciclopedia.dto.params.MalattiaParams;
import com.enciclopedia.esito.EsitoMessaggiRequestContextHolder;
import com.enciclopedia.esito.GenericResponseDto;
import com.enciclopedia.esito.costants.EsitoOperazioneEnum;
import com.enciclopedia.service.MalattiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( WebContstants.REST_CONTEX_STRING +"/malattia")
@Validated
public class MalattiaController {
    @Autowired
    private MalattiaService service;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    @GetMapping("/all")
    public ResponseEntity<GenericResponseDto<List<MalattiaDto>>> getAllMalattie(){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getAllMalattie");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.findAllMalattie()));
    }
    @GetMapping("/info")
    public ResponseEntity<GenericResponseDto<MalattiaDto>> getMalattiaInfo(MalattiaInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getMalattiaInfo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.findMalattiaByName(params)));
    }
    @PostMapping("/add")
    public ResponseEntity<GenericResponseDto<MalattiaDto>> addMalattia(MalattiaParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("addMalattia");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.addMalattia(params)));
    }
    @PutMapping("/change-info")
    public ResponseEntity<GenericResponseDto<MalattiaDto>> changeInfoMalattia(MalattiaChangeInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("addMalattia");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.changeInfoMalattia(params)));

    }
}
