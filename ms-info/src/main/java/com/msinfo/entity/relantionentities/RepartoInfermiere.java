package com.msinfo.entity.relantionentities;

import com.msinfo.entity.infermieri.Infermiere;
import com.msinfo.entity.reparto.Reparto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="reparto_infermiere")
public class RepartoInfermiere {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_relazione")
    private Integer idRelazione;

    @ManyToOne
    @JoinColumn(name = "id_reparto")
    private Reparto reparto;

    @ManyToOne
    @JoinColumn(name = "id_infermiere")
    private Infermiere infermiere;
}
