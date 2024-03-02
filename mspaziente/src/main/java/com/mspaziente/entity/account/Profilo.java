package com.mspaziente.entity.account;

import com.mspaziente.entity.Infermiere;
import com.mspaziente.entity.Medico;
import com.mspaziente.entity.Paziente;
import com.mspaziente.entity.relationentities.OperazioneConsentita;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "profilo")
public class Profilo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_profilo")
    private Integer idProfilo;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "descrizione")
    private String descrizione;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "profilo")
    private Set<OperazioneConsentita> operazioneConsentitaSet;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="profilo")
    private Set<Paziente> paziente;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="profilo")
    private Set<Infermiere> infermieri;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="profilo")
    private Set<Medico> medico;
}
