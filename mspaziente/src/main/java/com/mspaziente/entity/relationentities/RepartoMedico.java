package com.mspaziente.entity.relationentities;

import com.mspaziente.entity.Medico;
import com.mspaziente.entity.Reparto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reparto_medico")
public class RepartoMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_relazione")
    private Integer idRelazione;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_reparto")
    private Reparto reparto;
}
