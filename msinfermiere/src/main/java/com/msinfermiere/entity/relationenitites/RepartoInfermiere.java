package com.msinfermiere.entity.relationenitites;

import com.msinfermiere.entity.Infermiere;
import com.msinfermiere.entity.Reparto;
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
