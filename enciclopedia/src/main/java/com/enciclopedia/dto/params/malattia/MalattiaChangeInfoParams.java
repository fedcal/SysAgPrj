package com.enciclopedia.dto.params.malattia;

import lombok.Data;

@Data
public class MalattiaChangeInfoParams {
    private String nome;
    private Integer id;
    private String nuovoNome;
    private String nuovaDescrizione;
}
