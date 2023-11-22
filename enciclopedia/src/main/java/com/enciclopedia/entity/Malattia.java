package com.enciclopedia.entity;

import com.enciclopedia.entity.relationship.SintomoMalattia;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity(name = "malattia")
@Table(name = "malattia")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Malattia {
    @Id
    @Column(name="id_malattia")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idMalattia;

    @Column(name="nome")
    private String nome;

    @Column(name="descrizione")
    private String descrizione;
}
