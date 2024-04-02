package com.msmedico.entity.relationentities;

import com.msmedico.entity.Infermiere;
import com.msmedico.entity.Medicinale;
import com.msmedico.entity.paziente.CartellaClinica;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medicinale_sottoministrazione")
public class MedicinaleSottoministrazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relazione")
    private Integer idRelazione;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_infermiere",referencedColumnName="id_infermiere")
    private Infermiere infermiere;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_medicinale",referencedColumnName="id_medicinale")
    private Medicinale medicinale;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cartella_clinica",referencedColumnName="id_cartella_clinica")
    private CartellaClinica cartellaClinica;
}
