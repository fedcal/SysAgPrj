package com.mspaziente.entity.relationentities;

import com.mspaziente.entity.CartellaClinica;
import com.mspaziente.entity.Medico;
import com.mspaziente.entity.operazione.OperazioneMedica;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="operazione_prescrizione")
public class OperazionePrescrizione {
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
}
