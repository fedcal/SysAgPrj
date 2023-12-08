package com.bff.dto.enciclopedia.params.sintomomalattia;

import lombok.Data;

@Data
public class SintomoMalattiaChangeParams {
    private Integer idRelazione;
    private Integer idMalattia;
    private Integer idSintomo;

    private Integer newIdMalattia;
    private Integer newIdSitnomo;
}
