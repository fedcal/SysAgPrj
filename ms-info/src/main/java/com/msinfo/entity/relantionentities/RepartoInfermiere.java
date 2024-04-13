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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relazione")
    private Integer idRelazione;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_reparto")
    private Reparto reparto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_infermiere")
    private Infermiere infermiere;
}
