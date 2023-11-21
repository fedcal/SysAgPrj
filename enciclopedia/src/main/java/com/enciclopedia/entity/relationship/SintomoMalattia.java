package com.enciclopedia.entity.relationship;

import com.enciclopedia.entity.Malattia;
import com.enciclopedia.entity.Sintomo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "sintomo_malattia")
@Table(name = "sintomo_malattia")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SintomoMalattia {
    @Id
    @Column(name="id_relazione")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer idRelazione;
    @Embedded
    private SintomoMalattiaKey id;
    @ManyToOne
    @MapsId("malattia")
    @JoinColumn(name = "id_malattia")
    private Malattia malattia;

    @ManyToOne
    @MapsId("sintomo")
    @JoinColumn(name = "id_sintomo")
    private Sintomo sintomo;

}
