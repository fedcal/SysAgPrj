package com.msinfo.entity.relantionentities;

import com.msinfo.entity.medici.Medico;
import com.msinfo.entity.reparto.Reparto;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_reparto")
    private Reparto reparto;
}
