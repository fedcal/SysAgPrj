package com.msmedico.repository.relationentities;

import com.msmedico.entity.relationentities.OperazioneCartella;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OperazioneCartellaRepository extends JpaRepository<OperazioneCartella,Integer> {
    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.operazioneMedica.idOperazioneMedica = :idOperazione")
    List<OperazioneCartella> findByIdOperazione(@Param("idOperazione") Integer idOperazione);

    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.cartellaClinica.idCartellaClinica = :idCartellaClinica")
    List<OperazioneCartella> findByIdCartellaClinica(@Param("idCartellaClinica") Integer idCartellaClinica);

    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.medico.idMedico = :idMedico")
    List<OperazioneCartella> findByIdMedico(@Param("idMedico") Integer idMedico);

    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.operazioneMedica.nome = :nomeOperazione")
    List<OperazioneCartella> findByNomeOperazione(@Param("nomeOperazione") String nomeOperazione);


    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.medico.nome = :nomeMedico " +
            "AND oc.medico.cognome = :cognomeMedico")
    List<OperazioneCartella> findByNomeMedicoAndCognomeMedico(@Param("nomeMedico") String nomeMedico,
                                                              @Param("cognomeMedico") String cognomeMedico);

    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.medico.nome = :nomeMedico")
    List<OperazioneCartella> findByNomeMedico(@Param("nomeMedico") String nomeMedico);

    @Query("SELECT oc FROM OperazioneCartella oc WHERE oc.medico.cognome = :cognomeMedico")
    List<OperazioneCartella> findByCognomeMedico(@Param("cognomeMedico") String cognomeMedico);
}
