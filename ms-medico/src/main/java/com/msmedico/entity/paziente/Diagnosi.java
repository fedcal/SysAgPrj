package com.msmedico.entity.paziente;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "diagnosi")
public class Diagnosi {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_diagnosi")
    private Integer idDiagnosi;

    @Column(name = "tipo_diagnosi")
    private String tipoDiagnosi;

    @Column(name = "descrizione")
    private String descrizione;

    @ManyToOne
    @JoinColumn(name = "id_cartella_clinica")
    private CartellaClinica cartellaClinica;
}
