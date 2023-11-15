package com.bff.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enciclopedia")
public class EnciclopediaController {
    @GetMapping("/lista-farmaci")
    @Operation(summary = "Recupero lista farmaci", description = "API recupero lista comproprietari")
    public String getListaFarmaci(){
        return "lista farmaci";
    }
}
