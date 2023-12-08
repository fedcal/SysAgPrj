package com.bff.dto.enciclopedia.params.sintomo;

import lombok.Data;

@Data
public class SintomoChangeParams {
    private Integer idSintomo;
    private String nomeSintomo;
    private String descrizioneNuova;
    private String nomeSintomoNuovo;
}
