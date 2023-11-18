package com.enciclopedia.controller;

import com.enciclopedia.dto.MedicinaleDto;
import com.enciclopedia.dto.params.MedicinaleParams;
import com.enciclopedia.entity.Medicinale;
import com.enciclopedia.service.MedicinaleService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/enciclopedia/medicinale")
@Validated
@RequiredArgsConstructor
public class MedicinaleController {
    @Autowired
    private MedicinaleService service;

    @GetMapping("/all")
    public ResponseEntity<List<MedicinaleDto>> getAllMedicinali(){
        return ResponseEntity.ok(service.findAllMedicinali());
    }
    @GetMapping("/info")
    public ResponseEntity<MedicinaleDto> getInfoMedicinale(@RequestParam String nomeMedicinale){
        return ResponseEntity.ok(service.findByNome(nomeMedicinale));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedicinaleId(@PathParam("id") Integer idMedicinale){
        boolean medicinaleEliminato = service.deleteMedicinale(idMedicinale);
        if (medicinaleEliminato){
            return ResponseEntity.ok("Medicinale eliminato");
        }else {
            return ResponseEntity.status(404).body("Medicinale non eliminato");
        }
    }

    @PostMapping("/nuovo")
    public ResponseEntity<Medicinale> addMedicinale( MedicinaleParams params){
        return ResponseEntity.ok(service.addMedicinale(params));
    }

    @PostMapping("/modifica-info/{id}")
    public ResponseEntity<Medicinale> modificaMedicinale(@PathParam("id") Integer idMedicinale,
                                                         MedicinaleParams params){
        return  ResponseEntity.ok(service.modificaMedicinalle(idMedicinale,params));
    }

}
