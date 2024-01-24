package com.msmedico.repository.paziente;

import com.msmedico.entity.paziente.CartellaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartellaClinicaRepository extends JpaRepository<CartellaClinica,Integer> {
    @Query("SELECT cl FROM CartellaClinica cl WHERE cl.paziente.nome = :nome AND cl.paziente.cognome = :cognome")
    List<CartellaClinica> findByNomePazienteAndCognomePaziente(@Param("nome") String nome,@Param("cognome") String cognome);

    @Query("SELECT cl FROM CartellaClinica cl WHERE cl.paziente.idPaziente = :idPaziente")
    Optional<CartellaClinica> findByPazienteId(@Param("idPaziente") Integer idPaziente);

    @Query("SELECT cl FROM CartellaClinica cl WHERE cl.paziente.nome = :nome")
    List<CartellaClinica> findByNomePaziente(@Param("nome") String nome);

    @Query("SELECT cl FROM CartellaClinica cl WHERE cl.paziente.cognome = :cognome")
    List<CartellaClinica> findByCognomePaziente(@Param("cognome") String cognome);
}
