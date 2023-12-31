package com.msmedico.entity.relationentities;

import com.msmedico.entity.Medicinale;
import com.msmedico.entity.Medico;
import com.msmedico.entity.paziente.CartellaClinica;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medicinale_prescrizione")
public class MedicinalePrescrizione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relazione")
    private Integer idRelazione;
    @Column(name = "id_medico")
    private Integer medico;
    @Column(name = "id_medicinale")
    private Integer medicinale;
    @Column(name = "id_cartella_clinica")
    private Integer cartellaClinica;
}
