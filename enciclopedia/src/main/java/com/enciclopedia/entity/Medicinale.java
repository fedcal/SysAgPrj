package com.enciclopedia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "medicinale")
@Table(name = "medicinale")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Medicinale {
    @Id
    @Column(name="id_medicinale")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idMedicinale;

    @Column(name="nome")
    private String nome;

    @Column(name="descrizione")
    private String descrizione;

    @Column(name="dosaggio")
    private String dosaggio;
}
