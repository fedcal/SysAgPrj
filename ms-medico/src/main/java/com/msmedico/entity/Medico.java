package com.msmedico.entity;

import com.msmedico.entity.account.Profilo;
import com.msmedico.entity.relationentities.*;
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


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_account", referencedColumnName = "id_profilo")
    private Profilo profilo;

    @OneToMany(mappedBy = "medico")
    private Set<RepartoMedico> repartoMedicoSet;

    @OneToOne(mappedBy = "medico")
    private OperazioneCartella operazioneCartella;

    @OneToMany(mappedBy = "medico")
    private Set<MedicinalePrescrizione> medicinalePrescrizione;

    @OneToMany(mappedBy = "medico")
    private Set<VisitaPrescrizione> visitaPrescrizione;

    @OneToMany(mappedBy = "medico")
    private Set<VisitaSottoministrazioneMedico> visitaSottoministrazioneMedico;
}
