package com.mspaziente.entity;

import com.mspaziente.entity.account.Profilo;
import com.mspaziente.entity.relationentities.MedicinalePrescrizione;
import com.mspaziente.entity.relationentities.RepartoMedico;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Table(name = "medico")
@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Integer idMedico;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "turno")
    private String turno;


    @ManyToOne
    @JoinColumn(name = "tipo_account", referencedColumnName = "id_profilo")
    private Profilo profilo;

    @OneToMany(mappedBy = "medico")
    private Set<RepartoMedico> repartoMedicoSet;

    @OneToMany(mappedBy = "medico")
    private Set<MedicinalePrescrizione> medicinalePrescrizioneSet;
}
