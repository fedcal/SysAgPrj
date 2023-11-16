package com.enciclopedia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "Medicinale")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Medicinale {
    @Id
    @Column(name="idMedicinale")
    private Integer idMedicinale;
    @Column(name="nome")
    private String nome;
    @Column(name="descrizione")
    private String descrizione;
    @Column(name="dosaggio")
    private String dosaggio;
}
