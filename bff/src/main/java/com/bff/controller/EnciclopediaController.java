package com.bff.controller;

import com.bff.constants.WebContstants;

import com.bff.dto.enciclopedia.MalattiaDto;
import com.bff.dto.enciclopedia.params.malattia.MalattiaChangeInfoParams;
import com.bff.dto.enciclopedia.params.malattia.MalattiaInfoParams;
import com.bff.dto.enciclopedia.params.malattia.MalattiaParams;
import com.bff.esito.EsitoMessaggiRequestContextHolder;
import com.bff.esito.GenericResponseDto;
import com.bff.esito.costants.EsitoOperazioneEnum;
import com.bff.service.enciclopedia.MalattieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(WebContstants.REST_CONTEX_STRING+"/enciclopedia")
public class EnciclopediaController {
    @Autowired
    private MalattieService malattieService;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;

    // MALATTIE
    @GetMapping(value = "/malattie/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MalattiaDto>>> getAllMalattie(){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getAllMalattie");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(malattieService.findAllMalattie()));
    }

    @GetMapping("/malattie/info")
    public ResponseEntity<GenericResponseDto<MalattiaDto>> getMalattiaInfo(MalattiaInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getMalattiaInfo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(malattieService.findMalattiaInfo(params)));
    }
    @PostMapping("/malattie/add")
    public ResponseEntity<GenericResponseDto<MalattiaDto>> addMalattia(MalattiaParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("addMalattia");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(malattieService.addMalattia(params)));
    }
    @PutMapping("/malattie/change-info")
    public ResponseEntity<GenericResponseDto<MalattiaDto>> changeInfoMalattia(MalattiaChangeInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("changeInfoMalattia");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(malattieService.changeInfoMalattia(params)));

    }

    @DeleteMapping("/malattie/delete")
    public ResponseEntity<GenericResponseDto<String>> deleteMalattia(MalattiaInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("deleteMalattia");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(malattieService.deleteMalattia(params)));
    }

}
