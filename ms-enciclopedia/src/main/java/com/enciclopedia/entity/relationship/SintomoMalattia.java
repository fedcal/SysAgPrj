package com.enciclopedia.entity.relationship;

import com.enciclopedia.entity.Malattia;
import com.enciclopedia.entity.Sintomo;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "sintomo_malattia")
@Table(name = "sintomo_malattia")
@Data
public class SintomoMalattia {
    @Id
    @Column(name="id_relazione")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idRelazione;

    @Column(name = "id_malattia")
    private Integer idMalattia;

    @Column(name = "id_sintomo")
    private Integer idSintomo;

    @ManyToOne
    @MapsId("idMalattia")
    @JoinColumn(name = "id_malattia")
    private Malattia malattia;

    @ManyToOne
    @MapsId("idSintomo")
    @JoinColumn(name = "id_sintomo")
    private Sintomo sintomo;


}
