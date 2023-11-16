package com.enciclopedia.controller;

import com.enciclopedia.entity.Medicinale;
import com.enciclopedia.service.MedicinaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/enciclopedia/medicinali")
@Validated
@RequiredArgsConstructor
public class MedicinaleController {
    @Autowired
    private MedicinaleService service;

    @GetMapping("/all")
    public List<Medicinale> getAllMedicinali(){
        return service.findAllMedicinali();
    }

}
