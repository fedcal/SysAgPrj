package com.bff.dto.msinfermiere;

import com.bff.dto.msinfermiere.relationentities.MedicinaleCartellaDto;
import com.bff.dto.msinfermiere.relationentities.MedicinaleSottoministrazioneDto;
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
