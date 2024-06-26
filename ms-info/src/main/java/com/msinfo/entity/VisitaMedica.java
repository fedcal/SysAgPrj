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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_visita_medica")
    private Integer idVisitaMedica;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipologia")
    private String tipologia;

    @Column(name = "descrizione")
    private String descrizione;

    @OneToMany(mappedBy = "visitaMedica", fetch = FetchType.EAGER)
    private Set<VisitaPrescrizione> visitaPrescrizione;

    @OneToMany(mappedBy = "visitaMedica", fetch = FetchType.EAGER)
    private Set<VisitaSottoministrazioneMedico> visitaSottoministrazioneMedico;

    @OneToMany(mappedBy = "visitaMedica", fetch = FetchType.EAGER)
    private Set<VisitaSottoministrazioneInfermiere> visitaSottoministrazioneInfermiere;
}
