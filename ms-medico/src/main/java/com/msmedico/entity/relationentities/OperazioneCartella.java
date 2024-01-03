package com.msmedico.entity.relationentities;

import com.msmedico.entity.Medico;
import com.msmedico.entity.operazione.OperazioneMedica;
import com.msmedico.entity.operazione.RefertoOperazione;
import com.msmedico.entity.paziente.CartellaClinica;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "operazione_cartella")
public class OperazioneCartella {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relazione")
    private Integer idRelazione;

    @ManyToOne
    @JoinColumn(name = "id_operazione",referencedColumnName = "id_operazione_medica")
    private OperazioneMedica operazioneMedica;

    @ManyToOne
    @JoinColumn(name = "id_cartella",referencedColumnName = "id_cartella_clinica")
    private CartellaClinica cartellaClinica;

    @OneToOne
    @JoinColumn(name = "id_medico",referencedColumnName = "id_medico")
    private Medico medico;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_referto", referencedColumnName = "id_referto")
    private RefertoOperazione refertoOperazione;
}