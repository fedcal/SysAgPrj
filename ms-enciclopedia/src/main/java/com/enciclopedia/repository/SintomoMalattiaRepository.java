package com.enciclopedia.repository;


import com.enciclopedia.entity.relationship.SintomoMalattia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SintomoMalattiaRepository extends JpaRepository<SintomoMalattia,Integer> {
    @Query("select sm from sintomo_malattia sm where sm.idSintomo = :idSintomo")
    List<SintomoMalattia> findBySintomo(@Param("idSintomo") Integer idSintomo);
}
