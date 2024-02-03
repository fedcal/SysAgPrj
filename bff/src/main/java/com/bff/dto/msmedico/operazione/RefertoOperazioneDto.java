package com.bff.dto.msmedico.operazione;

import lombok.Data;

@Data
public class RefertoOperazioneDto {
    private Integer idReferto;
    private String tipologia;
    private String descrizione;
    private String dataReferto;
}
