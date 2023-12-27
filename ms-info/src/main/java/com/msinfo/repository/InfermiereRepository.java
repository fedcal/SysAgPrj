package com.msinfo.repository;

import com.msinfo.entity.infermieri.Infermiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InfermiereRepository extends JpaRepository<Infermiere,Integer> {
    @Query("SELECT inf FROM Infermiere inf WHERE " +
            "inf.nome = :nomeInfermiere " +
            "AND inf.cognome = :cognomeInfermiere")
    List<Infermiere> findByNomeAndCognome(String nomeInfermiere, String cognomeInfermiere);
    @Query("SELECT inf FROM Infermiere inf WHERE inf.nome = :nomeInfermiere")
    List<Infermiere> findByNome(@Param("nomeInfermiere") String nomeInfermiere);
    @Query("SELECT inf FROM Infermiere inf WHERE inf.cognome = :cognomeInfermiere")
    List<Infermiere> findByCognome(@Param("cognomeInfermiere")String cognomeInfermiere);
}
