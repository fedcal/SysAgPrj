package com.msinfo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "referto_visita_medica")
@Entity
public class RefertoVisitaMedica {
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
