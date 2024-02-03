package com.msinfermiere.entity.relationenitites;

import com.msinfermiere.entity.Infermiere;
import com.msinfermiere.entity.Medicinale;
import com.msinfermiere.entity.Medico;
import com.msinfermiere.entity.paziente.CartellaClinica;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medicinale_sottoministrazione")
public class MedicinaleSottoministrazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_relazione")
    private Integer idRelazione;

    @ManyToOne
    @JoinColumn(name = "id_infermiere",referencedColumnName="id_infermiere")
    private Infermiere infermiere;

    @ManyToOne
    @JoinColumn(name = "id_medicinale",referencedColumnName="id_medicinale")
    private Medicinale medicinale;

    @ManyToOne
    @JoinColumn(name = "id_cartella_clinica",referencedColumnName="id_cartella_clinica")
    private CartellaClinica cartellaClinica;
}
