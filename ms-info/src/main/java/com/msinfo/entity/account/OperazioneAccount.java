package com.msinfo.entity.account;

import com.msinfo.entity.relantionentities.OperazioneConsentita;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "operazione_account")
public class OperazioneAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operazione")
    private Integer idOperazione;

    @Column(name = "nome_operazione")
    private String nomeOperazione;

    @Column(name = "descrizione")
    private String descrizione;

    @OneToMany(mappedBy = "operazioneAccount", fetch = FetchType.EAGER)
    private Set<OperazioneConsentita> operazioneConsentitaSet;
}
