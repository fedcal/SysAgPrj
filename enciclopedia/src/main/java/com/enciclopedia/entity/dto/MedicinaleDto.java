package com.enciclopedia.entity.dto;

import lombok.Data;

@Data
public class MedicinaleDto {
    private int idMedicinale;
    private String nomeMedicinale;
    private String descrizioneMedicinale;
    private String controIndicazione;
    private String tipoUso;
}
