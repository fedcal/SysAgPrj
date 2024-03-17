package com.msmedico.repository.paziente;

import com.msmedico.entity.paziente.Paziente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PazienteRepository extends JpaRepository<Paziente,Integer> {
    @Query("SELECT p FROM Paziente p WHERE p.nome = :nome AND p.cognome = :cognome " +
            "AND p.dataNascita = :dataNascita")
    List<Paziente> findByNomeAndCognomeAndData(@Param("nome") String nome,
                                               @Param("cognome") String cognome,
                                               @Param("dataNascita") String dataNascita);

    @Query("SELECT p FROM Paziente p WHERE p.nome = :nome AND p.cognome = :cognome")
    List<Paziente> findByNomeAndCognome(@Param("nome") String nome,
                                        @Param("cognome") String cognome);

    @Query("SELECT p FROM Paziente p WHERE p.nome = :nome")
    List<Paziente> findByNome(@Param("nome") String nome);

    @Query("SELECT p FROM Paziente p WHERE p.cognome = :cognome")
    List<Paziente> findByCognome(@Param("cognome") String cognome);

    @Query("SELECT p FROM Paziente p WHERE p.dataNascita = :dataNascita")
    List<Paziente> findByDataNascita(@Param("dataNascita") String dataNascita);
}
