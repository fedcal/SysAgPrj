package com.msinfermiere.dto.operazione;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RefertoOperazioneDto {
    private Integer idReferto;
    private String tipologia;
    private String descrizione;
    private String dataReferto;
}
