package com.msinfo.entity.pazienti;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "diagnosi")
public class Diagnosi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diagnosi")
    private Integer idDiagnosi;

    @Column(name = "tipo_diagnosi")
    private String tipoDiagnosi;

    @Column(name = "descrizione")
    private String descrizione;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cartella_clinica")
    private CartellaClinica cartellaClinica;
}
