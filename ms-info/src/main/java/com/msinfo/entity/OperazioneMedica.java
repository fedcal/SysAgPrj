package com.msinfo.entity;

import com.msinfo.entity.relantionentities.OperazioneCartella;
import com.msinfo.entity.relantionentities.OperazionePrescrizione;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Data
@Table(name = "referto_operazione")
@Entity
public class OperazioneMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_operazione_medica")
    private Integer idOperazioneMedica;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "tipologia")
    private String tipologia;

    @OneToMany(mappedBy = "operazioneMedica")
    private Set<OperazioneCartella> operazioneCartella;

    @OneToMany(mappedBy = "operazioneMedica")
    private Set<OperazionePrescrizione> operazionePrescrizione;
}
