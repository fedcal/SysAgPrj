package com.msmedico.entity.paziente;

import com.msmedico.entity.relationentities.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "cartella_clinica")
public class CartellaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cartella_clinica")
    private Integer idCartellaClinica;

    @Column(name = "gruppo_sanguigno")
    private String gruppoSanguigno;
}
