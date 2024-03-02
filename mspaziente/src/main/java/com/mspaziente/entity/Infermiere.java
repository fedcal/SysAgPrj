package com.mspaziente.entity;

import com.mspaziente.entity.account.Profilo;
import com.mspaziente.entity.relationentities.MedicinaleSottoministrazione;
import com.mspaziente.entity.relationentities.VisitaSottoministrazioneInfermiere;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Table(name = "infermiere")
@Entity
public class Infermiere {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_infermiere")
    private Integer idInfermiere;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "turno")
    private String turno;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_account", referencedColumnName = "id_profilo")
    private Profilo profilo;

    @OneToMany(mappedBy = "infermiere")
    private Set<MedicinaleSottoministrazione> medicinaleSottoministrazione;

    @OneToMany(mappedBy = "infermiere")
    private Set<VisitaSottoministrazioneInfermiere> visitaSottoministrazione;
}
