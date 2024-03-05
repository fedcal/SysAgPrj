package com.msinfo.entity.relantionentities;

import com.msinfo.entity.OperazioneMedica;
import com.msinfo.entity.RefertoOperazione;
import com.msinfo.entity.medici.Medico;
import com.msinfo.entity.pazienti.CartellaClinica;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "operazione_cartella")
public class OperazioneCartella {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_relazione")
    private Integer idRelazione;

    @ManyToOne
    @JoinColumn(name = "id_operazione",referencedColumnName = "id_operazione_medica")
    private OperazioneMedica operazioneMedica;

    @ManyToOne
    @JoinColumn(name = "id_cartella",referencedColumnName = "id_cartella_clinica")
    private CartellaClinica cartellaClinica;

    @ManyToOne
    @JoinColumn(name = "id_medico",referencedColumnName = "id_medico")
    private Medico medico;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_referto", referencedColumnName = "id_referto")
    private RefertoOperazione refertoOperazione;
}
