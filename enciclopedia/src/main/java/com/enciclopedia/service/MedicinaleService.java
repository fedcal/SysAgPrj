package com.enciclopedia.service;

import com.enciclopedia.entity.Medicinale;
import com.enciclopedia.repository.MedicinaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicinaleService {
    @Autowired
    private MedicinaleRepository repository;

    public List<Medicinale> findAllMedicinali(){
        return  repository.findAll();
    }
}
