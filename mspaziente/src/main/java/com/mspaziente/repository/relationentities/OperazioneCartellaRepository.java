package com.mspaziente.repository.relationentities;

import com.mspaziente.entity.relationentities.OperazioneCartella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperazioneCartellaRepository extends JpaRepository<OperazioneCartella,Integer> {
    @Query("SELECT operazioneCartella FROM OperazioneCartella  operazioneCartella WHERE operazioneCartella.cartellaClinica.idCartellaClinica = :idCartellaClinica")
    List<OperazioneCartella> findByIdCartellaClinica(@Param("idCartellaClinica") Integer idCartellaClinica);
}
