package com.msmedico.entity.account;

import com.msmedico.entity.Medico;
import com.msmedico.entity.paziente.Paziente;
import com.msmedico.entity.relationentities.OperazioneConsentita;
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
}
