package com.enciclopedia.repository;

import com.enciclopedia.entity.Malattia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
public interface MalattiaRepository extends JpaRepository<Malattia, Integer> {
    Optional<Malattia> findByNome(String nome);
    @Transactional
    @Query(value = "UPDATE Malattia m SET m.nome = :nuovoNome WHERE m.id = :id ",nativeQuery = true)
    void changeNomeMalattia(@Param("nuovoNome") String nuovoNome,@Param("id") Integer idMalattia);
    @Query("UPDATE malattia m SET m.descrizione = :nuovaDescrizione WHERE m.id = :id ")
    void changeDescrizioneMalattia(@Param("nuovaDescrizione") String nuovaDescrizione,@Param("id") Integer idMalattia);
}
