package com.msinfo.entity.account;

import com.msinfo.entity.infermieri.Infermiere;
import com.msinfo.entity.medici.Medico;
import com.msinfo.entity.pazienti.Paziente;
import com.msinfo.entity.relantionentities.OperazioneConsentita;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "profilo")
public class Profilo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profilo")
    private Integer idProfilo;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "descrizione")
    private String descrizione;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "profilo")
    private Set<OperazioneConsentita> operazioneConsentitaSet;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="profilo")
    private Set<Medico> medico;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="profilo")
    private Set<Infermiere> infermieri;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="profilo")
    private Set<Paziente> pazienti;
}
