package com.msmedico.entity.relationentities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medicinale_prescrizione")
public class VisitaPrescrizione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_relazione")
    private Integer idRelazione;


}
