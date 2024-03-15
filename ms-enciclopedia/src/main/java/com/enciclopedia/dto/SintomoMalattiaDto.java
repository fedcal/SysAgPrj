package com.enciclopedia.dto;

import com.enciclopedia.entity.Malattia;
import com.enciclopedia.entity.Sintomo;
import lombok.Data;

@Data
public class SintomoMalattiaDto {
    private Integer idRelazione;
    private MalattiaDto idMalattia;
    private SintomoDto idSintomo;
}
