package com.msinfo.entity.reparto;

import com.msinfo.entity.medici.Medico;
import com.msinfo.entity.pazienti.Paziente;
import com.msinfo.entity.relantionentities.RepartoMedico;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "reparto")
public class Reparto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reparto")
    private Integer idReparto;

    @Column(name = "nome_reparto")
    private String nomeReparto;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "ala_reparto")
    private String alaReparto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "capo_reparto", referencedColumnName = "id_medico")
    private Medico capoReparto;

    @OneToMany(mappedBy = "reparto", fetch = FetchType.EAGER)
    private Set<RepartoMedico> repartoMedicoSet;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="reparto")
    private Set<Paziente> repartoPazienteSet;
}
