package com.msmedico.entity.paziente;

import com.msmedico.entity.relationentities.MalattiaCartella;
import com.msmedico.entity.relationentities.MedicinalePrescrizione;
import com.msmedico.entity.relationentities.OperazioneCartella;
import com.msmedico.entity.relationentities.VisitaMedicaCartella;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_paziente", referencedColumnName = "id_paziente")
    private Paziente paziente;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="cartellaClinica")
    private Set<Diagnosi> diagnosi;

    @OneToMany(mappedBy = "cartellaClinica")
    private Set<MalattiaCartella> malattiaCartella;

    @OneToMany(mappedBy = "cartellaClinica")
    private Set<VisitaMedicaCartella> visitaMedicaCartella;

    @OneToMany(mappedBy = "cartellaClinica")
    private Set<OperazioneCartella> operazioneCartella;

    /*@OneToMany(mappedBy = "cartellaClinica")
    private Set<MedicinalePrescrizione> medicinalePrescrizione;*/
}
