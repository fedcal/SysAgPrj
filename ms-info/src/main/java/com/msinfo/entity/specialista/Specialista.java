package com.msinfo.entity.specialista;

import com.msinfo.entity.account.Profilo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "specialista")
@Entity
public class Specialista {
    @Id
    @Column(name = "id_speicalista")
    private Integer idSpecialista;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "specializzazione")
    private String specializzazione;

    @Column(name = "turno")
    private String turno;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_account", referencedColumnName = "id_profilo")
    private Profilo profilo;

}
