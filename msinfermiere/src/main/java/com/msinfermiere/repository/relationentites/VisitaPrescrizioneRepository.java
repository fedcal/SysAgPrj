package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.relationentites.VisitaPrescrizione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitaPrescrizioneRepository extends JpaRepository<VisitaPrescrizione,Integer> {
    @Query("SELECT visitaPrescrizione FROM VisitaPrescrizione visitaPrescrizione WHERE " +
            "visitaPrescrizione.visitaMedica.idVisitaMedica = :idVisita")
    List<VisitaPrescrizione> findByIdMedicinale(@Param("idVisita") Integer idVisita);
    @Query("SELECT visitaPrescrizione FROM VisitaPrescrizione visitaPrescrizione WHERE " +
            "visitaPrescrizione.medico.idMedico = :idMedico")
    List<VisitaPrescrizione> findByIdMedico(@Param("idMedico") Integer idMedico);
    @Query("SELECT visitaPrescrizione FROM VisitaPrescrizione visitaPrescrizione WHERE " +
            "visitaPrescrizione.cartellaClinica.idCartellaClinica = :idCartellaClinica")
    List<VisitaPrescrizione> findByIdCartellaClinica(@Param("idCartellaClinica") Integer idCartellaClinica);
    @Query("SELECT visitaPrescrizione FROM VisitaPrescrizione visitaPrescrizione WHERE " +
            "visitaPrescrizione.visitaMedica.nome = :nomeVisita")
    List<VisitaPrescrizione> findByNomeMedicinale(@Param("nomeVisita")String nomeVisita);
    @Query("SELECT visitaPrescrizione FROM VisitaPrescrizione visitaPrescrizione WHERE " +
            "visitaPrescrizione.medico.nome = :nomeMedico AND "+
            "visitaPrescrizione.medico.cognome = :cognomeMedico")
    List<VisitaPrescrizione> findByNomeAndCognomeMedico(@Param("nomeMedico") String nomeMedico,@Param("cognomeMedico") String cognomeMedico);
    @Query("SELECT visitaPrescrizione FROM VisitaPrescrizione visitaPrescrizione WHERE " +
            "visitaPrescrizione.medico.nome = :nomeMedico")
    List<VisitaPrescrizione> findByNomeMedico(@Param("nomeMedico") String nomeMedico);
    @Query("SELECT visitaPrescrizione FROM VisitaPrescrizione visitaPrescrizione WHERE " +
            "visitaPrescrizione.medico.cognome = :cognomeMedico")
    List<VisitaPrescrizione> findByCognomeMedico(@Param("cognomeMedico") String cognomeMedico);
}
