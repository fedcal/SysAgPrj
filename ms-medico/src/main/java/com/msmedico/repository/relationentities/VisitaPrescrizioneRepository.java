package com.msmedico.repository.relationentities;

import com.msmedico.entity.relationentities.VisitaPrescrizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitaPrescrizioneRepository extends JpaRepository<VisitaPrescrizione,Integer> {

    @Query("SELECT op FROM VisitaPrescrizione op WHERE op.medico.nome = :nomeMedico " +
            "AND op.medico.cognome = :cognomeMedico")
    List<VisitaPrescrizione> findByNomeAndCognomeMedico(@Param("nomeMedico") String nomeMedico,
                                                        @Param("cognomeMedico") String cognomeMedico);
    @Query("SELECT op FROM VisitaPrescrizione op WHERE op.visitaMedica.nome = :nomeVisita")
    List<VisitaPrescrizione> findByNomeVisita(@Param("nomeVisita") String nomeVisita);
    @Query("SELECT op FROM VisitaPrescrizione op WHERE op.medico.cognome = :cognomeMedico")
    List<VisitaPrescrizione> findByCognomeMedico(@Param("cognomeMedico") String cognomeMedico);
    @Query("SELECT op FROM VisitaPrescrizione op WHERE op.medico.nome = :nomeMedico")
    List<VisitaPrescrizione> findByNomeMedico(@Param("nomeMedico") String nomeMedico);
    @Query("SELECT op FROM VisitaPrescrizione op WHERE op.medico.idMedico = :idMedico")
    List<VisitaPrescrizione> findbyIdMedico(@Param("idMedico") Integer idMedico);
    @Query("SELECT op FROM VisitaPrescrizione op WHERE op.cartellaClinica.idCartellaClinica = :idCartella")
    List<VisitaPrescrizione> findbyIdCartella(@Param("idCartella") Integer idCartella);
    @Query("SELECT op FROM VisitaPrescrizione op WHERE op.visitaMedica.idVisitaMedica = :idVisita")
    List<VisitaPrescrizione> findbyIdVisita(@Param("idVisita") Integer idVisita);
}
