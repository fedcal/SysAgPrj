package com.enciclopedia.dto.output;

import com.enciclopedia.dto.MalattiaDto;
import com.enciclopedia.dto.SintomoDto;
import lombok.Data;

@Data
public class SintomoMalattiaOutput {
    private Integer idRelazione;
    private MalattiaDto malattiaDto;
    private SintomoDto sintomoDto;
}
