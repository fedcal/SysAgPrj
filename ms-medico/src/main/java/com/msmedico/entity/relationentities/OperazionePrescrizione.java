package com.msmedico.entity.relationentities;

import com.msmedico.entity.Medico;
import com.msmedico.entity.operazione.OperazioneMedica;
import com.msmedico.entity.paziente.CartellaClinica;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="operazione_prescrizione")
public class OperazionePrescrizione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relazione")
    private Integer idRelazione;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_operazione",referencedColumnName = "id_operazione_medica")
    private OperazioneMedica operazioneMedica;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cartella",referencedColumnName = "id_cartella_clinica")
    private CartellaClinica cartellaClinica;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_medico",referencedColumnName = "id_medico")
    private Medico medico;
}
