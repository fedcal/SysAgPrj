package com.msinfo.entity.pazienti;

import com.msinfo.entity.account.Profilo;
import com.msinfo.entity.reparto.Reparto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "paziente")
public class Paziente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paziente")
    private Integer idPaziente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "data_nascita")
    private String dataNascita;

    @Column(name = "luogo_nascita")
    private String luogoNascita;

    @Column(name = "provincia_nascita")
    private String provinciaNascita;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contatto_riferimento", referencedColumnName = "id_contatto")
    private ContattoRiferimento contattoRiferimento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_reparto", referencedColumnName = "id_reparto")
    private Reparto reparto;

    @ManyToOne
    @JoinColumn(name="tipo_account", referencedColumnName = "id_profilo")
    private Profilo profilo;

}
