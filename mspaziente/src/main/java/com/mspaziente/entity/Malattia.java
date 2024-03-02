package com.mspaziente.entity;

import com.mspaziente.entity.relationentities.MalattiaCartella;
import jakarta.persistence.*;
import lombok.Data;

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
