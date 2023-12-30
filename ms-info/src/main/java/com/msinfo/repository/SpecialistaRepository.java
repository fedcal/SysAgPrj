package com.msinfo.repository;

import com.msinfo.entity.specialista.Specialista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialistaRepository extends JpaRepository<Specialista,Integer> {
    @Query("select spe from Specialista spe " +
            "where spe.nome = :nome " +
            "and spe.cognome = :cognome")
    List<Specialista> findByNomeAndCognome(@Param("nome") String nome, @Param("cognome") String cognome);
    @Query("select spe from Specialista spe where spe.nome = :nome")
    List<Specialista> findByNome(@Param("nome") String nome);
    @Query("select spe from Specialista spe where spe.cognome = :cognome")
    List<Specialista> findByCognome(@Param("cognome") String cognome);
}
