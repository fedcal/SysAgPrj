package com.msinfermiere.entity.visitamedica;

import com.msinfermiere.entity.relationentites.VisitaPrescrizione;
import com.msinfermiere.entity.relationentites.VisitaEffettuataInfermiere;
import com.msinfermiere.entity.relationentites.VisitaEffettuataMedico;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "visita_medica")
public class VisitaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_visita_medica")
    private Integer idVisitaMedica;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipologia")
    private String tipologia;

    @Column(name = "descrizione")
    private String descrizione;

    @OneToMany(mappedBy = "visitaMedica")
    private Set<VisitaPrescrizione> visitaPrescrizione;

    @OneToMany(mappedBy = "visitaMedica")
    private Set<VisitaEffettuataMedico> visitaSottoministrazioneMedico;

    @OneToMany(mappedBy = "visitaMedica")
    private Set<VisitaEffettuataInfermiere> visitaEffettuataInfermiere;
}
