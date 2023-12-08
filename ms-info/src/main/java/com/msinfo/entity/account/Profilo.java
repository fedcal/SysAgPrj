package com.msinfo.entity.account;

import com.msinfo.entity.infermieri.Infermiere;
import com.msinfo.entity.medici.Medico;
import com.msinfo.entity.pazienti.Paziente;
import com.msinfo.entity.relantionentities.OperazioneConsentita;
import com.msinfo.entity.specialista.Specialista;
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

    @OneToMany(mappedBy = "profilo")
    private Set<OperazioneConsentita> operazioneConsentitaSet;

    @OneToMany(mappedBy="profilo")
    private Set<Medico> medici;

    @OneToMany(mappedBy="profilo")
    private Set<Infermiere> infermieri;

    @OneToMany(mappedBy="profilo")
    private Set<Specialista> specialisti;

    @OneToMany(mappedBy="profilo")
    private Set<Paziente> pazienti;
}
