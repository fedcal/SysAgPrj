package com.msmedico.entity.relationentities;

import com.msmedico.entity.Medico;
import com.msmedico.entity.Reparto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reparto_medico")
public class RepartoMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relazione")
    private Integer idRelazione;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_reparto")
    private Reparto reparto;
}
