package com.enciclopedia.entity;

import com.enciclopedia.entity.relationship.SintomoMalattia;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity(name = "sintomo")
@Table(name = "sintomo")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Sintomo {
    @Id
    @Column(name="id_sintomo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idSintomo;

    @Column(name="nome")
    private String nome;

    @Column(name="descrizione")
    private String descrizione;

}
