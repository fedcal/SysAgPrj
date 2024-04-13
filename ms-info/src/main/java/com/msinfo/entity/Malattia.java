package com.msinfo.entity;

import com.msinfo.entity.relantionentities.MalattiaCartella;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Entity(name = "malattia")
@Table(name = "malattia")
@Data
public class Malattia {
    @Id
    @Column(name="id_malattia")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idMalattia;

    @Column(name="nome")
    private String nome;

    @Column(name="descrizione")
    private String descrizione;

    @OneToMany(mappedBy = "malattia", fetch = FetchType.EAGER)
    private Set<MalattiaCartella> cartelle;
}
