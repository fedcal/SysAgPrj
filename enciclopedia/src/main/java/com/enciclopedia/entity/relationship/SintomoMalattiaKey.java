package com.enciclopedia.entity.relationship;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class SintomoMalattiaKey implements Serializable {
    @Column(name = "id_malattia")
    private Integer studentId;

    @Column(name = "id_sintomo")
    private Integer courseId;
}
