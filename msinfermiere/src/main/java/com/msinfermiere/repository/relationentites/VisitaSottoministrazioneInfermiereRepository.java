package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.relationentites.VisitaEffettuataInfermiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitaSottoministrazioneInfermiereRepository extends JpaRepository<VisitaEffettuataInfermiere,Integer> {
    @Query("SELECT medSott FROM VisitaEffettuataInfermiere medSott WHERE " +
            "medSott.visitaMedica.idVisitaMedica = :idMedicinale")
    List<VisitaEffettuataInfermiere> findByIdVisita(@Param("idMedicinale") Integer idMedicinale);

    @Query("SELECT medSott FROM VisitaEffettuataInfermiere medSott WHERE " +
            "medSott.infermiere.idInfermiere = :idInfermiere")
    List<VisitaEffettuataInfermiere> findByIdInfemiere(@Param("idInfermiere") Integer idInfermiere);

    @Query("SELECT medSott FROM VisitaEffettuataInfermiere medSott WHERE " +
            "medSott.cartellaClinica.idCartellaClinica = :idCartellaClinica")
    List<VisitaEffettuataInfermiere> findByIdCartellaClinica(@Param("idCartellaClinica") Integer idCartellaClinica);
    @Query("SELECT medSott FROM VisitaEffettuataInfermiere medSott WHERE " +
            "medSott.infermiere.nome = :nomeInfermiere AND " +
            "medSott.infermiere.cognome = :cognomeInfermiere")
    List<VisitaEffettuataInfermiere> findByNomeAndCognomeInfermiere(@Param("nomeInfermiere") String nomeInfermiere,
                                                                    @Param("cognomeInfermiere") String cognomeInfermiere);

    @Query("SELECT medSott FROM VisitaEffettuataInfermiere medSott WHERE " +
            "medSott.infermiere.nome = :nomeInfermiere")
    List<VisitaEffettuataInfermiere> findByNomeInfermiere(@Param("nomeInfermiere") String nomeInfermiere);

    @Query("SELECT medSott FROM VisitaEffettuataInfermiere medSott WHERE " +
            "medSott.infermiere.cognome = :cognomeInfermiere")
    List<VisitaEffettuataInfermiere> findByCognomeInfermiere(@Param("cognomeInfermiere") String cognomeInfermiere);

    @Query("SELECT medSott FROM VisitaEffettuataInfermiere medSott WHERE " +
            "medSott.visitaMedica.nome = :nomeVisita")
    List<VisitaEffettuataInfermiere> findByNomeVisita(@Param("nomeVisita") String nomeVisita);
}
