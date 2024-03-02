package com.mspaziente.entity.relationentities;

import com.mspaziente.entity.account.OperazioneAccount;
import com.mspaziente.entity.account.Profilo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="operazione_consentita")
public class OperazioneConsentita {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_operazione_consentita")
    private Integer idOperazioneConentita;

    @ManyToOne
    @JoinColumn(name = "tipo_account")
    private Profilo profilo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operazione")
    private OperazioneAccount operazioneAccount;
}
