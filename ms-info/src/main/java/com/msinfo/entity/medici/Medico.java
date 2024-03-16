package com.msinfo.entity.medici;

import com.msinfo.entity.account.Profilo;
import com.msinfo.entity.relantionentities.RepartoMedico;
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

}
