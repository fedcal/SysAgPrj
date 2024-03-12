package com.msinfermiere.repository.relationentites;

import com.msinfermiere.entity.relationentites.VisitaSottoministrazioneInfermiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitaSottoministrazioneInfermiereRepository extends JpaRepository<VisitaSottoministrazioneInfermiere,Integer> {
    @Query("SELECT medSott FROM VisitaSottoministrazioneInfermiere medSott WHERE " +
            "medSott.visitaMedica.idVisitaMedica = :idMedicinale")
    List<VisitaSottoministrazioneInfermiere> findByIdVisita(@Param("idMedicinale") Integer idMedicinale);

    @Query("SELECT medSott FROM VisitaSottoministrazioneInfermiere medSott WHERE " +
            "medSott.infermiere.idInfermiere = :idInfermiere")
    List<VisitaSottoministrazioneInfermiere> findByIdInfemiere(@Param("idInfermiere") Integer idInfermiere);

    @Query("SELECT medSott FROM VisitaSottoministrazioneInfermiere medSott WHERE " +
            "medSott.cartellaClinica.idCartellaClinica = :idCartellaClinica")
    List<VisitaSottoministrazioneInfermiere> findByIdCartellaClinica(@Param("idCartellaClinica") Integer idCartellaClinica);
    @Query("SELECT medSott FROM VisitaSottoministrazioneInfermiere medSott WHERE " +
            "medSott.infermiere.nome = :nomeInfermiere AND " +
            "medSott.infermiere.cognome = :cognomeInfermiere")
    List<VisitaSottoministrazioneInfermiere> findByNomeAndCognomeInfermiere(@Param("nomeInfermiere") String nomeInfermiere,
                                                                            @Param("cognomeInfermiere") String cognomeInfermiere);

    @Query("SELECT medSott FROM VisitaSottoministrazioneInfermiere medSott WHERE " +
            "medSott.infermiere.nome = :nomeInfermiere")
    List<VisitaSottoministrazioneInfermiere> findByNomeInfermiere(@Param("nomeInfermiere") String nomeInfermiere);

    @Query("SELECT medSott FROM VisitaSottoministrazioneInfermiere medSott WHERE " +
            "medSott.infermiere.cognome = :cognomeInfermiere")
    List<VisitaSottoministrazioneInfermiere> findByCognomeInfermiere(@Param("cognomeInfermiere") String cognomeInfermiere);

    @Query("SELECT medSott FROM VisitaSottoministrazioneInfermiere medSott WHERE " +
            "medSott.visitaMedica.nome = :nomeVisita")
    List<VisitaSottoministrazioneInfermiere> findByNomeVisita(@Param("nomeVisita") String nomeVisita);
}
