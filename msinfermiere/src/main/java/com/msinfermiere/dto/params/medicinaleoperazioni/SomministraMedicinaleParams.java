package com.msinfermiere.dto.params.medicinaleoperazioni;

import lombok.Data;

@Data
public class SomministraMedicinaleParams {
    private Integer infermiere;
    private Integer medicinale;
    private Integer cartellaClinica;
}
