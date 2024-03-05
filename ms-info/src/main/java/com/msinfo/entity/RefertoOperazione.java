package com.msinfo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "operazione_cartella")
public class RefertoOperazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_referto")
    private Integer idReferto;

    @Column(name = "tipologia")
    private String tipologia;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "data_referto")
    private String dataReferto;
}
