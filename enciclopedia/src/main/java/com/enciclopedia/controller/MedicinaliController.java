package com.enciclopedia.controller;

import com.enciclopedia.dto.FarmaciDto;
import com.enciclopedia.entity.dto.MedicinaleDto;
import com.enciclopedia.esito.EsitoMessaggiRequestContextHolder;
import com.enciclopedia.esito.GenericResponseDto;
import com.enciclopedia.service.MedicinaleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicinali")
public class MedicinaliController {
    @Autowired
    private MedicinaleService medicinaleService;
    @Autowired
    private EsitoMessaggiRequestContextHolder esitoMessaggiRequestContextHolder;
    @GetMapping("/lista")
    @Operation(summary = "Recupero lista medicinali", description = "API recupero lista comproprietari")
    public ResponseEntity<GenericResponseDto<List<MedicinaleDto>>> getListaFarmaci(){
        return ResponseEntity.ok(esitoMessaggiRequestContextHolder.buildGenericResponse(medicinaleService.findAllMedicinali()));
    }
}
