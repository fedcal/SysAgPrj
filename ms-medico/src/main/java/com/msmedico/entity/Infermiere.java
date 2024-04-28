package com.msmedico.entity;

import com.msmedico.entity.account.Profilo;
import com.msmedico.entity.relationentities.MedicinaleSottoministrazione;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Data
@Table(name = "infermiere")
@Entity
public class Infermiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_infermiere")
    private Integer idInfermiere;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "turno")
    private String turno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_account", referencedColumnName = "id_profilo")
    private Profilo profilo;
}
