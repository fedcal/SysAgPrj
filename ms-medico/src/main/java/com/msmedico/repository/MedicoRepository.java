package com.msmedico.repository;

import com.msmedico.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Integer> {
    @Query("select me from Medico me " +
            "where me.nome = :nome " +
            "and me.cognome = :cognome")
    List<Medico> findByNomeAndCognome(@Param("nome") String nome, @Param("cognome") String cognome);
    @Query("select me from Medico me where me.nome = :nome")
    List<Medico> findByNome(@Param("nome") String nome);
    @Query("select me from Medico me where me.cognome = :cognome")
    List<Medico> findByCognome(@Param("cognome") String cognome);
}
