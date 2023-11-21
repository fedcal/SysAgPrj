package com.bff.controller;

import com.bff.service.EnciclopediaService;
import com.enciclopedia.model.MedicinaleDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enciclopedia")
public class EnciclopediaController {
    @Autowired
    private EnciclopediaService enciclopediaService;

    @GetMapping("/lista-medicinali")
    @Operation(summary = "Recupero lista farmaci", description = "API recupero lista comproprietari")
    public List<MedicinaleDto> getListaFarmaci(){
        return enciclopediaService.getAllMedicinali();
    }

}
