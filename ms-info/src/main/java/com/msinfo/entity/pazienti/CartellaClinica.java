package com.msinfo.entity.pazienti;

import com.msinfo.entity.relantionentities.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "cartella_clinica")
public class CartellaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cartella_clinica")
    private Integer idCartellaClinica;

    @Column(name = "gruppo_sanguigno")
    private String gruppoSanguigno;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="cartellaClinica")
    private Set<Diagnosi> diagnosi;

    @OneToMany(mappedBy = "cartellaClinica", fetch = FetchType.EAGER)
    private Set<MalattiaCartella> malattiaCartella;

    @OneToMany(mappedBy = "cartellaClinica", fetch = FetchType.EAGER)
    private Set<VisitaMedicaCartella> visitaMedicaCartella;

    @OneToMany(mappedBy = "cartellaClinica", fetch = FetchType.EAGER)
    private Set<OperazioneCartella> operazioneCartella;

    @OneToMany(mappedBy = "cartellaClinica", fetch = FetchType.EAGER)
    private Set<MedicinalePrescrizione> medicinalePrescrizione;

    @OneToMany(mappedBy = "cartellaClinica", fetch = FetchType.EAGER)
    private Set<VisitaPrescrizione> visitaPrescrizione;

    @OneToMany(mappedBy = "cartellaClinica", fetch = FetchType.EAGER)
    private Set<VisitaSottoministrazioneMedico> visitaSottoministrazioneMedico;

    @OneToMany(mappedBy = "cartellaClinica", fetch = FetchType.EAGER)
    private Set<VisitaSottoministrazioneInfermiere> visitaSottoministrazioneInfermiere;

    @OneToMany(mappedBy = "cartellaClinica", fetch = FetchType.EAGER)
    private Set<MedicinaleCartella> medicinaleCartella;

    @OneToMany(mappedBy = "cartellaClinica", fetch = FetchType.EAGER)
    private Set<OperazionePrescrizione> operazionePrescrizione;

    @OneToMany(mappedBy = "cartellaClinica", fetch = FetchType.EAGER)
    private Set<MedicinaleSottoministrazione> medicinaleSottoministrazione;
}
