package com.msinfermiere.repository.paziente;

import com.msinfermiere.entity.paziente.Paziente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PazienteRepository extends JpaRepository<Paziente,Integer> {
    @Query("SELECT p FROM Paziente p WHERE p.nome = :nome AND " +
            "p.cognome = :cognome")
    List<Paziente> findByNomeAndCognomePaziente(@Param("nome") String nome,
                                                @Param("cognome") String cognome);
    @Query("SELECT p FROM Paziente p WHERE p.nome = :nome")
    List<Paziente> findByNomePaziente(@Param("nome") String nome);
    @Query("SELECT p FROM Paziente p WHERE p.cognome = :cognome")
    List<Paziente> findByCognomePaziente(@Param("cognome") String cognome);
}
