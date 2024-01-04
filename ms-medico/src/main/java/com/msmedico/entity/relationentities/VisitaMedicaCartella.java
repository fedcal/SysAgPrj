package com.msmedico.entity.relationentities;

import com.msmedico.entity.visitamedica.RefertoVisitaMedica;
import com.msmedico.entity.visitamedica.VisitaMedica;
import com.msmedico.entity.paziente.CartellaClinica;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "visita_medica_cartella")
public class VisitaMedicaCartella {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relazione")
    private Integer idRelazione;

    /*@Column(name = "id_cartella")
    private Integer idCartella;

    @Column(name = "id_visita_medica")
    private Integer idVisitaMedica;

    @Column(name = "id_referto")
    private Integer idReferto;*/

    @ManyToOne
    @JoinColumn(name = "id_cartella",referencedColumnName="id_cartella_clinica")
    private CartellaClinica cartellaClinica;

    @ManyToOne
    @JoinColumn(name = "id_visita_medica",referencedColumnName="id_visita_medica")
    private VisitaMedica visitaMedica;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_referto", referencedColumnName = "id_referto")
    private RefertoVisitaMedica refertoVisitaMedica;
}
