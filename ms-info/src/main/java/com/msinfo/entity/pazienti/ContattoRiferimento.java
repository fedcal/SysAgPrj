package com.msinfo.entity.pazienti;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contatto_riferimento")
public class ContattoRiferimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_contatto")
    private Integer idContatto;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "numero_cellulare")
    private String numeroCellulare;

    @OneToOne(mappedBy = "contattoRiferimento")
    private Paziente paziente;
}
