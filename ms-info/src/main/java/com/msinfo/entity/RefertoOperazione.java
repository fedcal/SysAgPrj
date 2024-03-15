package com.msinfo.entity;

import com.msinfo.entity.relantionentities.OperazioneCartella;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "referto_operazione")
public class RefertoOperazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_referto")
    private Integer idReferto;

    @Column(name = "tipologia")
    private String tipologia;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "data_referto")
    private String dataReferto;
}
