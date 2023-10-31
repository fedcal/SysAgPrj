package com.robotmedico.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/robot-medico")
public class ProvaController {
    @GetMapping(value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Recupero lista comproprietari", description = "API recupero lista comproprietari")
    public ResponseEntity<ProvaDto> getStatus(){
        ProvaDto provaDto = new ProvaDto();
        provaDto.setSaluto("ciao");
        return ResponseEntity.ok(provaDto);
    }
}
