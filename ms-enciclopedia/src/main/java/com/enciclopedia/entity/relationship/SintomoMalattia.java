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

    @ManyToOne
    @JoinColumn(name = "id_malattia",referencedColumnName="id_malattia")
    private Malattia idMalattia;

    @ManyToOne
    @JoinColumn(name = "id_sintomo",referencedColumnName="id_sintomo")
    private Sintomo idSintomo;

}
