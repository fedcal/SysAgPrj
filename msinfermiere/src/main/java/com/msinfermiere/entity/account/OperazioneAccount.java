package com.msinfermiere.entity.account;

import com.msinfermiere.entity.relationenitites.OperazioneConsentita;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "operazione_account")
public class OperazioneAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_operazione")
    private Integer idOperazione;

    @Column(name = "nome_operazione")
    private String nomeOperazione;

    @Column(name = "descrizione")
    private String descrizione;

    @OneToMany(mappedBy = "operazioneAccount")
    private Set<OperazioneConsentita> operazioneConsentitaSet;
}

