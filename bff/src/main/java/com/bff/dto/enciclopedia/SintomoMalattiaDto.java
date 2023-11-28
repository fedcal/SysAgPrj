package com.bff.dto.enciclopedia;

import lombok.Data;

@Data
public class SintomoMalattiaDto {
    private Integer idRelazione;
    private Integer idMalattia;
    private Integer idSintomo;
    private SintomoDto sintomo;
    private MalattiaDto malattia;
}
