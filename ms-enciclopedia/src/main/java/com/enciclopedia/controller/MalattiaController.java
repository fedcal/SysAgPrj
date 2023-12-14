package com.enciclopedia.controller;

import com.enciclopedia.constants.WebContstants;
import com.enciclopedia.dto.MalattiaDto;
import com.enciclopedia.dto.params.malattia.MalattiaChangeInfoParams;
import com.enciclopedia.dto.params.malattia.MalattiaInfoParams;
import com.enciclopedia.dto.params.malattia.MalattiaParams;
import com.enciclopedia.esito.EsitoMessaggiRequestContextHolder;
import com.enciclopedia.esito.GenericResponseDto;
import com.enciclopedia.esito.costants.EsitoOperazioneEnum;
import com.enciclopedia.service.MalattiaService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponseDto<List<MalattiaDto>>> getAllMalattie(){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getAllMalattie");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.findAllMalattie()));
    }
    @GetMapping("/info")
    public ResponseEntity<GenericResponseDto<MalattiaDto>> getMalattiaInfo(@ParameterObject MalattiaInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("getMalattiaInfo");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.findMalattiaInfo(params)));
    }
    @PostMapping("/add")
    public ResponseEntity<GenericResponseDto<MalattiaDto>> addMalattia(@ParameterObject MalattiaParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("addMalattia");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.addMalattia(params)));
    }
    @PutMapping("/change-info")
    public ResponseEntity<GenericResponseDto<MalattiaDto>> changeInfoMalattia(@ParameterObject MalattiaChangeInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("changeInfoMalattia");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.changeInfoMalattia(params)));

    }

    @DeleteMapping("/delete")
    public ResponseEntity<GenericResponseDto<String>> deleteMalattia(@ParameterObject MalattiaInfoParams params){
        esitoMessaggiRequestContextHolder.setCodRet(EsitoOperazioneEnum.OK);
        esitoMessaggiRequestContextHolder.setOperationId("deleteMalattia");
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(service.deleteMalattia(params)));
    }
}
