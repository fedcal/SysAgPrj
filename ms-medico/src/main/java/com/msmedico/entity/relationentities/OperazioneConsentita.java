package com.msmedico.entity.relationentities;

import com.msmedico.entity.account.OperazioneAccount;
import com.msmedico.entity.account.Profilo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="operazione_consentita")
public class OperazioneConsentita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operazione_consentita")
    private Integer idOperazioneConentita;

    @ManyToOne
    @JoinColumn(name = "tipo_account")
    private Profilo profilo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operazione")
    private OperazioneAccount operazioneAccount;
}
