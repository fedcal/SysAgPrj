package com.enciclopedia.service;

import com.enciclopedia.entity.dto.MedicinaleDto;
import com.enciclopedia.repository.service.MedicinaleRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicinaleService {
    @Autowired
    private MedicinaleRepoService medicinaleRepoService;

    public List<MedicinaleDto> findAllMedicinali(){
        return medicinaleRepoService.findAllMedicinali();
    }
}
