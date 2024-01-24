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
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer idRelazione;

    @Column(name = "id_malattia")
    private Integer idMalattia;

    @Column(name = "id_sintomo")
    private Integer idSintomo;

}
