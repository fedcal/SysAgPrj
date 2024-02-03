package com.msinfermiere.dto;

import com.msinfermiere.dto.relationentities.MedicinaleCartellaDto;
import com.msinfermiere.dto.relationentities.MedicinaleSottoministrazioneDto;
import com.msinfermiere.entity.relationentites.MedicinaleCartella;
import com.msinfermiere.entity.relationentites.MedicinaleSottoministrazione;
import lombok.Data;

import java.util.Set;
@Data
public class MedicinaleDto {
    private Integer idMedicinale;
    private String nome;
    private String descrizione;
    private String dosaggio;
    private Set<MedicinaleCartellaDto> medicinaleCartella;
    private Set<MedicinaleSottoministrazioneDto> medicinaleSottoministrazione;
}
