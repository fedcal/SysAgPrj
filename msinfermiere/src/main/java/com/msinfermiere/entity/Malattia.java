package com.msinfermiere.entity;

import com.msinfermiere.entity.relationenitites.MalattiaCartella;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "malattia")
@Table(name = "malattia")
@Data
public class Malattia {
    @Id
    @Column(name="id_malattia")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer idMalattia;

    @Column(name="nome")
    private String nome;

    @Column(name="descrizione")
    private String descrizione;

    @OneToMany(mappedBy = "malattia")
    private Set<MalattiaCartella> cartelle;
}
