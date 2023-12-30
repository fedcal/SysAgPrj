package com.bff.dto.msenciclopedia;

import lombok.Data;

@Data
public class MedicinaleDto {
    private Integer idMedicinale;
    private String nome;
    private String descrizione;
    private String dosaggio;
}
