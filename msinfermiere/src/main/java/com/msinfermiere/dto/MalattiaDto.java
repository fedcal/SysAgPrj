package com.msinfermiere.dto;

import com.msinfermiere.dto.relationentities.MalattiaCartellaDto;
import com.msinfermiere.entity.relationentites.MalattiaCartella;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;
@Data
public class MalattiaDto {
    private Integer idMalattia;
    private String nome;
    private String descrizione;
    private Set<MalattiaCartellaDto> cartelle;
}
