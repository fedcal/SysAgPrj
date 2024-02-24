package com.msinfermiere.dto.params;

import lombok.Data;

@Data
public class PazienteFiltratiParams {
    private Integer idPaziente;

    private String nome;
    private String cognome;
}
