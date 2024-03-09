package com.msinfo.entity;

import com.msinfo.entity.relantionentities.MedicinalePrescrizione;
import com.msinfo.entity.relantionentities.VisitaPrescrizione;
import com.msinfo.entity.relantionentities.VisitaSottoministrazioneInfermiere;
import com.msinfo.entity.relantionentities.VisitaSottoministrazioneMedico;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "visita_medica")
public class VisitaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    private Set<VisitaSottoministrazioneMedico> visitaSottoministrazioneMedico;

    @OneToMany(mappedBy = "visitaMedica")
    private Set<VisitaSottoministrazioneInfermiere> visitaSottoministrazioneInfermiere;

    @OneToMany(mappedBy = "visitaMedica")
    private Set<MedicinalePrescrizione> medicinalePrescrizione;
}
