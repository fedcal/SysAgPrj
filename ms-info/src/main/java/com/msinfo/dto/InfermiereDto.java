package com.msinfo.dto;

import com.msinfo.entity.account.Profilo;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class InfermiereDto {
    private Integer idInfermiere;
    private String nome;
    private String cognome;
    private String turno;
    private Profilo profilo;
}
