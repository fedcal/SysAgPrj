package com.msinfo.entity.infermieri;

import com.msinfo.entity.account.Profilo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "infermiere")
@Entity
public class Infermiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_infermiere")
    private Integer idInfermiere;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "turno")
    private String turno;

    @ManyToOne
    @JoinColumn(name="id_profilo")
    private Profilo profilo;
}
