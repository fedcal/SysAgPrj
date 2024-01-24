package com.bff.dto.msenciclopedia.output;

import com.bff.dto.msenciclopedia.MalattiaDto;
import com.bff.dto.msenciclopedia.SintomoDto;
import lombok.Data;

@Data
public class SintomoMalattiaOutput {
    private Integer idRelazione;
    private MalattiaDto malattiaDto;
    private SintomoDto sintomoDto;
}
