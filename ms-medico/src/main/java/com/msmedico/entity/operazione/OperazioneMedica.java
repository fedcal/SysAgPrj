package com.msmedico.entity.operazione;

import com.msmedico.entity.relationentities.OperazioneCartella;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Table(name = "referto_operazione")
@Entity
public class OperazioneMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
