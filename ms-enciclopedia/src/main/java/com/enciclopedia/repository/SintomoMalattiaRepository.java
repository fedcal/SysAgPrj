package com.enciclopedia.repository;


import com.enciclopedia.entity.relationship.SintomoMalattia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SintomoMalattiaRepository extends JpaRepository<SintomoMalattia,Integer> {
    @Query("SELECT sm FROM sintomo_malattia sm WHERE sm.idSintomo.idSintomo" +
            " = :idSintomo")
    List<SintomoMalattia> findBySintomo(@Param("idSintomo") Integer idSintomo);
    @Query("SELECT sm FROM sintomo_malattia sm WHERE sm.idSintomo.idSintomo = :idSintomo AND sm.idMalattia.idMalattia = :idMalattia")
    Optional<SintomoMalattia> findBySintomoAndMalattia(@Param("idSintomo")Integer idSintomo,
                                                       @Param("idMalattia") Integer idMalattia);
}
