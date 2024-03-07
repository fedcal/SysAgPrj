package com.mspaziente.dto;

import com.mspaziente.dto.relationentities.MedicinaleCartellaDto;
import com.mspaziente.dto.relationentities.MedicinaleSottoministrazioneDto;
import lombok.Data;

import java.util.Set;
@Data
public class MedicinaleDto {
    private Integer idMedicinale;
    private String nome;
    private String descrizione;
    private String dosaggio;
}
