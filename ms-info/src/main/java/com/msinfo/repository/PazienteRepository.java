package com.msinfo.repository;

import com.msinfo.entity.pazienti.Paziente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PazienteRepository extends JpaRepository<Paziente,Integer> {
    List<Paziente> findByNome(String nome);
    List<Paziente> findByCognome(String cognome);

    List<Paziente> findByDataNascita(String dataNascita);

    @Query("select pa from Paziente pa where pa.contattoRiferimento.idContatto = :idContatto")
    List<Paziente> findByIdContatto(@Param("idContatto") Integer idContatto);

    @Query("select pa from Paziente pa where pa.contattoRiferimento.nome = :nome")
    List<Paziente> findByNomeContatto(@Param("nome") String nome);

    @Query("select pa from Paziente pa where pa.contattoRiferimento.cognome = :cognome")
    List<Paziente> findByCognomeContatto(@Param("cognome") String cognome);

    @Query("select pa from Paziente pa where pa.contattoRiferimento.numeroCellulare = :numeroCellulare")
    List<Paziente> findByContattoNumeroCellulare(@Param("numeroCellulare") String numeroCellulare);

    @Query("select pa from Paziente pa where pa.nome = :nome and pa.cognome = :cognome")
    List<Paziente> findByNomeAndCognome(@Param("nome") String nome,@Param("cognome") String cognome);
}
