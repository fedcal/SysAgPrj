package com.msinfermiere.entity.relationenitites;

import com.msinfermiere.entity.Medico;
import com.msinfermiere.entity.operazione.OperazioneMedica;
import com.msinfermiere.entity.operazione.RefertoOperazione;
import com.msinfermiere.entity.paziente.CartellaClinica;
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
