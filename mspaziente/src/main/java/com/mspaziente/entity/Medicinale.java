package com.mspaziente.entity;

import com.mspaziente.entity.relationentities.MedicinaleCartella;
import com.mspaziente.entity.relationentities.MedicinalePrescrizione;
import com.mspaziente.entity.relationentities.MedicinaleSottoministrazione;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "medicinale")
public class Medicinale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicinale")
    private Integer idMedicinale;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "dosaggio")
    private String dosaggio;

    @OneToMany(mappedBy = "medicinale")
    private Set<MedicinaleCartella> medicinaleCartella;

    @OneToMany(mappedBy = "medicinale")
    private Set<MedicinaleSottoministrazione> medicinaleSottoministrazione;

    @OneToMany(mappedBy = "medicinale")
    private Set<MedicinalePrescrizione> medicinalePrescrizioneSet;
}
