package com.msinfo.entity.relantionentities;

import com.msinfo.entity.VisitaMedica;
import com.msinfo.entity.medici.Medico;
import com.msinfo.entity.pazienti.CartellaClinica;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "visita_prescrizione")
public class VisitaPrescrizione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relazione")
    private Integer idRelazione;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_medico",referencedColumnName="id_medico")
    private Medico medico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_visita",referencedColumnName="id_visita_medica")
    private VisitaMedica visitaMedica;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cartella_clinica",referencedColumnName="id_cartella_clinica")
    private CartellaClinica cartellaClinica;
}
