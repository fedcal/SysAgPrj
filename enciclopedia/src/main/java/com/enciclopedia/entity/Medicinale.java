package com.enciclopedia.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Medicinale", schema = "VE")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Medicinale {
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "idMedicinale", columnDefinition = "int")
    @Schema(name = "Identificativo del medicinale")
    private Integer idMedicinale;

    @Column(name = "nome", columnDefinition = "varchar(50)")
    @Schema(name = "Nome del medicinale")
    private String nomeMedicinale;

    @Column(name = "descrizione", columnDefinition = "varchar(500)")
    @Schema(name = "Descrizione del medicinale")
    private String descrizioneMedicinale;

    @Column(name = "controIndicazione", columnDefinition = "varchar(500)")
    @Schema(name = "Identificativo del medicinale")
    private String controIndicazione;

    @Column(name = "tipoUso", columnDefinition = "varchar(20)")
    @Schema(name = "Identificativo del medicinale")
    private String tipoUso;

}
