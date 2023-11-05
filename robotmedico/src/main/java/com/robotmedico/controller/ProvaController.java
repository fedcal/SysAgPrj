package com.robotmedico.controller;

import com.robotmedico.service.RobotMedicoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/robot-medico")
public class ProvaController {
    @Autowired
    private RobotMedicoService service;

    @GetMapping(value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Recupero lista comproprietari", description = "API recupero lista comproprietari")
    public ResponseEntity<String> getStatus(){

        return ResponseEntity.ok(service.prova());
    }
}
