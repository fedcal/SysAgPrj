package com.msinfermiere.entity.paziente;

import com.msinfermiere.entity.Reparto;
import com.msinfermiere.entity.account.Profilo;
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

    @Column(name = "luogoNascita")
    private String luogoNascita;

    @Column(name = "provinciaNascita")
    private String provinciaNascita;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contatto_riferimento", referencedColumnName = "id_contatto")
    private ContattoRiferimento contattoRiferimento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_reparto", referencedColumnName = "id_reparto")
    private Reparto reparto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_account", referencedColumnName = "id_profilo")
    private Profilo profilo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cartella_clinica", referencedColumnName = "id_cartella_clinica")
    private CartellaClinica cartellaClinica;
}